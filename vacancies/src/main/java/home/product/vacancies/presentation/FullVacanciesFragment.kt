package home.product.vacancies.presentation

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import home.product.searchjob2.App
import home.product.searchjob2.presentation.MainActivity
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.addElement
import home.product.vacancies.data.utilits.ItemOffsetDecoration
import home.product.vacancies.R
import home.product.vacancies.databinding.FullVacanciesFragmentBinding
import home.product.vacancies.di.DaggerVacanciesComponent
import home.product.vacancies.domain.entities.VacanciesDto
import home.product.vacancies.presentation.adapters.VacanciesAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class FullVacanciesFragment @Inject constructor() : Fragment() {
    private var _binding: FullVacanciesFragmentBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
        VacanciesAdapter { idVacant -> toDetail(idVacant) }

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FullVacanciesFragmentBinding.inflate(inflater)
        DaggerVacanciesComponent.builder().coreComponent(App.coreComponent(requireContext()))
            .build().inject2(this)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.fullVacancies) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        val img = context?.let { AppCompatResources.getDrawable(it, R.drawable.arrow) }
        binding.fullSearchVacant.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)

        binding.fullSearchVacant.setOnTouchListener(object : View.OnTouchListener {

            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                val DRAWABLE_LEFT = 0
                val DRAWABLE_TOP = 1
                val DRAWABLE_RIGHT = 2
                val DRAWABLE_BOTTOM = 3
                if (event!!.action == MotionEvent.ACTION_UP) {
                    if (binding.fullSearchVacant.compoundDrawables[DRAWABLE_LEFT] != null) {
                        if (binding.fullSearchVacant.compoundDrawables[DRAWABLE_LEFT].bounds.width() >= event.rawX - binding.fullSearchVacant.left) {
                            findNavController().popBackStack()
                            return true
                        }
                    }
                }
                return false
            }

        })
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mainViewModel.getOffersVacancies()
            mainViewModel.responseOffersVacancies.onEach { list ->
                vacanciesAdapter.submitList(list.vacancies)
                binding.vacanciesAmount.text = "${list.vacancies.size} вакансий"
            }.launchIn(this)

        }
    }

    private fun toDetail(vacancy: VacanciesDto) {
        lifecycleScope.launch(Dispatchers.Main) {
            if (vacancy.isFavorite && helpScopeReference.cardScopeTurnButton) {
                mainViewModel.saveInFavorite(vacancy)
                addElement = true
                MainActivity.helpScopeReference3.elementDelete = false

                val action =
                    FullVacanciesFragmentDirections.actionFullVacanciesFragmentToDetailFragment(
                        vacancy
                    )
                delay(300)
                findNavController().navigate(action)
                helpScopeReference.cardScopeTurnButton = false
            } else if (!vacancy.isFavorite && helpScopeReference.cardScopeTurnButton) {
                mainViewModel.deleteVacancy(vacancy)
                MainActivity.helpScopeReference3.elementDelete = true
                addElement = false

                val action =
                    FullVacanciesFragmentDirections.actionFullVacanciesFragmentToDetailFragment(
                        vacancy
                    )
                delay(300)
                findNavController().navigate(action)
                helpScopeReference.cardScopeTurnButton = false
            } else if (!vacancy.isFavorite && !helpScopeReference.cardScopeTurnButton) {
                mainViewModel.deleteVacancy(vacancy)
                MainActivity.helpScopeReference3.elementDelete = true
                addElement = false
            } else {
                mainViewModel.saveInFavorite(vacancy)
                addElement = true
                MainActivity.helpScopeReference3.elementDelete = false
            }
        }
    }
}

