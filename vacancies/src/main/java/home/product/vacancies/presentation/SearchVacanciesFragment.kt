package home.product.vacancies.presentation

import android.content.Intent
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
import home.product.vacancies.data.utilits.ItemOffsetDecoration
import home.product.vacancies.data.utilits.ItemOffsetDecoration2
import home.product.vacancies.presentation.adapters.OffersMainAdapter
import home.product.vacancies.databinding.FragmentSearchVacanciesBinding
import home.product.vacancies.di.DaggerVacanciesComponent

import home.product.vacancies.presentation.adapters.VacanciesAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class SearchVacanciesFragment : Fragment() {
    private var _binding: FragmentSearchVacanciesBinding? = null
    val binding get() = _binding!!
//@Inject
//private val  mainViewModel: MainViewModel by viewModels()
private val mainViewModel: MainViewModel by viewModels {
    DaggerVacanciesComponent.create().mainViewModelFactory()

}
    private val vacanciesAdapter =
        VacanciesAdapter { vacancy->  }
    private val offersMainAdapter =
        OffersMainAdapter { link ->
            Toast.makeText(requireContext(),"Переход на сайт:$link",Toast.LENGTH_LONG).show()
            val browserIntent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            browserIntent.data= Uri.parse(link)
            startActivity(browserIntent)
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchVacanciesBinding.inflate(inflater)

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
}