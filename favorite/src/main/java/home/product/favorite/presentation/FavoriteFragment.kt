package home.product.favorite.presentation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import home.product.core.database.MainEntity
import home.product.favorite.databinding.FragmentFavoriteBinding
import home.product.favorite.presentation.FavoriteFragment.helpScopeReference2.cardScopeTurnButton
import home.product.favorite.presentation.di.DaggerFavoriteComponent
import home.product.favorite.presentation.utils.ItemOffsetDecoration
import home.product.searchjob2.App
import home.product.searchjob2.MainObject
import home.product.searchjob2.presentation.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
        FavoriteAdapter { idVacant -> toDaoScope(idVacant) }

    @Inject
    lateinit var favoriteViewModel: FavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater)
        DaggerFavoriteComponent.builder().coreComponent(App.coreComponent(requireContext())).build()
            .inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.vacanciesFavorite) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        val menuItemId =
            MainActivity.helpScopeReference3.bottomNavigationViewMainReference.menu.getItem(1).itemId
        val badge =
            MainActivity.helpScopeReference3.bottomNavigationViewMainReference.getOrCreateBadge(
                menuItemId
            )
        if (badge.isVisible) {
            badge.isVisible = false
            MainActivity.helpScopeReference3.addElement = false
        }
        favoriteViewModel.loadFavoriteVacancies()
        lifecycleScope.launch { }
        favoriteViewModel.responseVacancies.observe(viewLifecycleOwner) { list ->
            if (list.size % 10 == 2 || list.size % 10 == 3 || list.size % 10 == 4) {
                binding.vacanciesCount.text = "${list.size.toString()} вакансии"
            } else if (list.size % 10 == 5 || list.size % 10 == 6 || list.size % 10 == 7 || list.size % 10 == 9 || list.size % 10 == 0) {
                binding.vacanciesCount.text = "${list.size.toString()} вакансий"
            } else {
                if (list.size % 10 == 1) {
                    binding.vacanciesCount.text = "${list.size.toString()} вакансия"
                }
            }
            vacanciesAdapter.submitList(list)
        }
    }

    private fun toDaoScope(vacancy: MainEntity) {
        if (vacancy.isFavorite) {
            MainObject.addingElement = MainObject.addingElement -1
        } else {
            favoriteViewModel.deleteVacancy(vacancy)
            MainActivity.helpScopeReference3.elementDelete = true
            MainObject.addingElement = MainObject.addingElement -1
        }

        if (cardScopeTurnButton && vacancy.isFavorite) {
            val action =
                FavoriteFragmentDirections.actionFavoriteFragmentToFavoriteFragmentDetail(vacancy)
            findNavController().navigate(action)
            cardScopeTurnButton = false
        }
    }


    object helpScopeReference2 {
        var cardScopeTurnButton = false
    }

}