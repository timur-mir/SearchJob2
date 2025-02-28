package home.product.vacancies.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import home.product.core.database.di.CoreComponent
import home.product.searchjob2.App.Companion.coreComponent
import home.product.searchjob2.presentation.MainActivity
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.addElement
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.elementDelete
import home.product.vacancies.data.utilits.ItemOffsetDecoration
import home.product.vacancies.data.utilits.ItemOffsetDecoration2
import home.product.vacancies.presentation.adapters.OffersMainAdapter
import home.product.vacancies.databinding.FragmentSearchVacanciesBinding
import home.product.vacancies.di.DaggerVacanciesComponent
import home.product.vacancies.di.DomainModule
import home.product.vacancies.domain.entities.VacanciesDto
import home.product.vacancies.presentation.adapters.VacanciesAdapter
import home.product.vacancies.presentation.helpScopeReference.cardScopeTurnButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class SearchVacanciesFragment : Fragment() {
    private var _binding: FragmentSearchVacanciesBinding? = null
    val binding get() = _binding!!
    @Inject
lateinit var mainViewModel:MainViewModel
    private val vacanciesAdapter =
        VacanciesAdapter { vacancy-> toDetail(vacancy)  }
    private val offersMainAdapter =
        OffersMainAdapter { link ->
            Toast.makeText(requireContext(),"Переход на сайт:$link",Toast.LENGTH_LONG).show()
            val browserIntent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            browserIntent.data= Uri.parse(link)
            startActivity(browserIntent)
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchVacanciesBinding.inflate(inflater)
        DaggerVacanciesComponent.builder().coreComponent(coreComponent(requireContext())). build().inject(this)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.topOffers) {
            adapter = offersMainAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
                setHasFixedSize(true)
                addItemDecoration(ItemOffsetDecoration2(requireContext()))
            }
        }
        with(binding.vacancies3) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        binding.getAllVacancies.setOnClickListener{
            val action = SearchVacanciesFragmentDirections.actionSearchVacanciesFragmentToFullVacanciesFragment()
            findNavController().navigate(action)
        }
    }
    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mainViewModel!!.getOffersVacancies()
            mainViewModel!!.responseOffersOffersMain.onEach { list ->
                offersMainAdapter.items = list
            }.launchIn(this)
            mainViewModel!!.responseOffersVacancies.onEach { list ->
                val listVacancies=list.vacancies
                binding.getAllVacancies.text="Ещё ${listVacancies.size-3} вакансии"
                vacanciesAdapter.submitList(listVacancies.take(3))
            }.launchIn(this)
        }
    }
  private fun toDetail(vacancy: VacanciesDto) {
      lifecycleScope.launch(Dispatchers.Main) {
          if (vacancy.isFavorite&&cardScopeTurnButton) {
              mainViewModel.saveInFavorite(vacancy)
              addElement = true
              elementDelete = false

              val action =
                  SearchVacanciesFragmentDirections.actionSearchVacanciesFragmentToDetailFragment(
                      vacancy
                  )
              delay(300)
              findNavController().navigate(action)
              cardScopeTurnButton = false
          } else if (!vacancy.isFavorite&&cardScopeTurnButton) {
              mainViewModel.deleteVacancy(vacancy)
              elementDelete = true
              addElement = false

              val action =
                  SearchVacanciesFragmentDirections.actionSearchVacanciesFragmentToDetailFragment(
                      vacancy
                  )
              delay(300)
              findNavController().navigate(action)
              cardScopeTurnButton = false
          }
         else if (!vacancy.isFavorite&&!cardScopeTurnButton) {
              mainViewModel.deleteVacancy(vacancy)
              elementDelete = true
              addElement = false
          }
          else
          {
              mainViewModel.saveInFavorite(vacancy)
              addElement = true
              elementDelete = false
          }
      }
  }
}
object helpScopeReference {
    var turnButton = false
    var cardScopeTurnButton=false
}