package home.product.vacancies.presentation.usefavorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import home.product.vacancies.databinding.FavoriteFragmentBinding

class FavoriteFragment: Fragment() {
     private var _binding: FavoriteFragmentBinding? = null
            val binding get() = _binding!!
            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View? {
                _binding = FavoriteFragmentBinding.inflate(inflater)
                return binding.root
            }
}