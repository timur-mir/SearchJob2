package home.howework.searchjob.features.usemessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.product.vacancies.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding?= null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater)
        return binding.root
    }

}