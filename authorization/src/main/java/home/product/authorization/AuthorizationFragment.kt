package home.product.authorization

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import home.product.authorization.AuthorizationFragment.Help.flagBackground
import home.product.authorization.databinding.FragmentAuthorizationBinding
import home.product.navigations.navigate

class AuthorizationFragment : Fragment() {
    private var _binding: FragmentAuthorizationBinding? = null
    val binding get() = _binding!!
    private var drawableRight: Drawable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }
    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawableRight=context?.let { AppCompatResources.getDrawable(it, R.drawable.close2) }
        binding.editField.addTextChangedListener(checkTextWatcher)
        binding.nextAction.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(binding.editField.text.toString())
                    .matches()
            ) {
                val action =AuthorizationFragmentDirections.actionAuthorizationFragmentToConfirmationFragment(binding.editField.text.toString())
               findNavController().navigate(action)
            } else {
                binding.nextAction.isEnabled = false
                flagBackground=true
                binding.editField.background=
                    AppCompatResources.getDrawable(requireContext(), R.drawable.search_shape)
                binding.attentionMessage.visibility=View.VISIBLE
                 binding.editField.error="Вы ввели неправильный формат почты"
            }
        }
        binding.editField.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View?, event: MotionEvent?): Boolean {
                val DRAWABLE_LEFT=0
                val DRAWABLE_TOP=1
                val DRAWABLE_RIGHT=2
                val DRAWABLE_BOTTOM=3
                if(event!!.action == MotionEvent.ACTION_UP){
                    if(binding.editField.compoundDrawables[DRAWABLE_RIGHT]!=null) {
                        if (event.rawX >= binding.editField.right - binding.editField.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
                            binding.editField.text.clear()
                            return true
                        }
                    }
                }
                return false
            }

        })
    }



    private val checkTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if( flagBackground) {
                binding.editField.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.custom_border)
                binding.editField.text.clear()
                binding.attentionMessage.visibility=View.INVISIBLE
                flagBackground=false
            }
            binding.nextAction.isEnabled = true
            val img = context?.let { AppCompatResources.getDrawable(it, R.drawable.close2) }
            binding.editField.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            binding.editField.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null)
        }
        override fun afterTextChanged(s: Editable?) {

        }

    }
    object Help{
        var flagBackground=false
    }
}