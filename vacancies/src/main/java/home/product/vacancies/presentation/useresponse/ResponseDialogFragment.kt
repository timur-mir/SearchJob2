package home.product.vacancies.presentation.useresponse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import home.product.vacancies.data.utilits.convertToPixels
import home.product.vacancies.databinding.ResponseDialogFragmentBinding

class ResponseDialogFragment:DialogFragment() {
    private var _binding: ResponseDialogFragmentBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=ResponseDialogFragmentBinding.inflate(inflater)
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
        binding.responseLatter.setOnClickListener{
            binding.responseLatter.visibility=View.GONE
            binding.editResponseLatter.visibility=View.VISIBLE
        }
        binding.responseClickButtonDialog.setOnClickListener{
            dismiss()
        }

    }

}