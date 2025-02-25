package home.product.favorite.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import home.product.core.database.MainEntity
import home.product.favorite.databinding.FragmentFavoriteBinding
import home.product.favorite.presentation.di.DaggerFavoriteComponent
import home.product.favorite.presentation.utils.ItemOffsetDecoration
import home.product.searchjob2.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    val binding get() = _binding!!
    private val vacanciesAdapter =
       FavoriteAdapter { idVacant -> toDaoScope(idVacant) }

    private fun toDaoScope(vacancy: MainEntity) {
        if (vacancy.isFavorite) {
            favoriteViewModel.saveVacancy(vacancy)
        }
        else
        {
            favoriteViewModel.deleteVacancy(vacancy)
        }
    }

    @Inject
    lateinit var favoriteViewModel: FavoriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater)
        DaggerFavoriteComponent.builder().coreComponent(App.coreComponent(requireContext())). build().inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.vacanciesFavorite) {
            adapter = vacanciesAdapter
            setHasFixedSize(true)
            addItemDecoration(ItemOffsetDecoration(requireContext()))
        }
        favoriteViewModel.loadFavoriteVacancies()
        lifecycleScope.launch {  }
        favoriteViewModel.responseVacancies.observe(viewLifecycleOwner){list->
            binding.vacanciesCount.text="${list.size.toString()} вакансия"
            vacanciesAdapter.submitList(list)
        }
    }




}