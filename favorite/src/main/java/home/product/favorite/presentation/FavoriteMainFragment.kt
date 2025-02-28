package home.product.favorite.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.product.favorite.R
import home.product.favorite.databinding.FragmentFavoriteBinding
import home.product.favorite.databinding.FragmentFavoriteMainBinding
import home.product.favorite.presentation.di.DaggerFavoriteComponent
import home.product.searchjob2.App

class FavoriteMainFragment : Fragment() {
    private var _binding: FragmentFavoriteMainBinding? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentFavoriteMainBinding.inflate(inflater)
            return binding.root
        }

    }


