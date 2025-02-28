package home.product.favorite.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import home.product.favorite.R
import home.product.favorite.databinding.FragmentResponseFavoriteDialogBinding

class ResponseFavoriteDialogFragment : DialogFragment() {
    private var _binding: FragmentResponseFavoriteDialogBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResponseFavoriteDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.responseLatterD.setOnClickListener {
            binding.responseLatterD.visibility = View.GONE
            binding.editResponseLatterD.visibility = View.VISIBLE
        }
        binding.responseClickButtonDialogD.setOnClickListener {
            dismiss()
        }
    }
}