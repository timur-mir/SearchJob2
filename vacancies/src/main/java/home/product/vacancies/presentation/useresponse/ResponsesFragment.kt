package home.product.vacancies.presentation.useresponse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import home.product.vacancies.databinding.FragmentResponsesBinding

class ResponsesFragment : Fragment() {
    private var _binding: FragmentResponsesBinding?= null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResponsesBinding.inflate(inflater)
        return binding.root
    }

}