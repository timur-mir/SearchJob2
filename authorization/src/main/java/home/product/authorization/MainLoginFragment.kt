package home.product.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import home.product.authorization.databinding.FragmentConfirmationBinding
import home.product.authorization.databinding.FragmentMainLoginBinding


class MainLoginFragment : Fragment() {
    private var _binding: FragmentMainLoginBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainLoginBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//       val nav=  Navigation.findNavController(requireActivity(), home.product.navigations.R.id.main_login_host)
    }
}