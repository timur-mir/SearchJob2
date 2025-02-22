package home.product.favorite.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import home.product.favorite.databinding.FragmentFavoriteBinding
import home.product.favorite.presentation.di.DaggerFavoriteComponent
import home.product.searchjob2.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    val binding get() = _binding!!
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
        favoriteViewModel.loadFavoriteVacancies()
        lifecycleScope.launch {  }
        favoriteViewModel.responseVacancies.observe(viewLifecycleOwner){list->
            Toast.makeText(requireContext(), list.toString(),Toast.LENGTH_LONG).show()
            binding.txView.text=list[0].toString()
        }
    }




}