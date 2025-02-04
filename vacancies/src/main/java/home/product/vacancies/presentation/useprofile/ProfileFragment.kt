package home.howework.searchjob.features.useprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.product.vacancies.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding?= null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentProfileBinding.inflate(inflater)
        return binding.root
    }


}