package home.product.favorite.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import home.product.favorite.R
import home.product.favorite.databinding.FragmentFavoriteBinding
import home.product.favorite.databinding.FragmentFavoriteDetailBinding
import home.product.favorite.presentation.utils.convertToPixels

class FavoriteFragmentDetail : Fragment() {
    private var _binding: FragmentFavoriteDetailBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentFavoriteDetailBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: FavoriteFragmentDetailArgs by navArgs()

        binding.isBackF.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.responseClickButtonF.setOnClickListener{
           findNavController().navigate(R.id.responseFavoriteDialogFragment)
        }
        if(arg.aboutVacancy.appliedNumber!=0) {
            if(arg.aboutVacancy.appliedNumber==1 &&arg.aboutVacancy.appliedNumber!=11 )
                binding.appliedNumberF.text ="${arg.aboutVacancy.appliedNumber.toString()} человек уже откликнулся"
            else
                binding.appliedNumberF.text ="${arg.aboutVacancy.appliedNumber.toString()} человек уже откликнулось"
        }
        if (arg.aboutVacancy.lookingNumber!=0)
        {
            if(arg.aboutVacancy.lookingNumber%10==2||arg.aboutVacancy.lookingNumber%10==3||arg.aboutVacancy.lookingNumber%10==4) {
                binding.lookedSomeF.text="${arg.aboutVacancy.lookingNumber.toString()} человека сейчас смотрят"
            }
            else {
                binding.lookedSomeF.text="${arg.aboutVacancy.lookingNumber.toString()} человек сейчас смотрит"
            }
        }
        binding.lookedSomeF.text = arg.aboutVacancy.title.toString()
        binding.vacancyF.text=arg.aboutVacancy.title
        binding.salaryF.text=arg.aboutVacancy.salary.full
        binding.expirienceF.text=arg.aboutVacancy.experience.text
        binding.shedulesF.text=arg.aboutVacancy.schedules.joinToString (","){it.toString()  }
        binding.companyCaptionF.text=arg.aboutVacancy.company
        binding.companyAddressF.text="${arg.aboutVacancy.address.town} , ${arg.aboutVacancy.address.street} , ${arg.aboutVacancy.address.house}"
        ///////////////////////////////
        binding.aboutCompanyF.text=arg.aboutVacancy.description
        ///////////////////////////////
        binding.youTasksF.text=arg.aboutVacancy.responsibilities
        //////////////////////////////
        createQuestionView(arg.aboutVacancy.questions)
    }
    private fun createQuestionView(list:ArrayList<String>){
        val listSize = list.size
        val layoutQuestionContainer = binding.questionContainerF
        for (i in 1..listSize) {
            val layoutQuestionContainerLastView =
                layoutQuestionContainer.getChildAt(layoutQuestionContainer.childCount - 1)
            val rowQuestion = LinearLayout(requireContext())
            rowQuestion.orientation = LinearLayout.HORIZONTAL
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            params.leftMargin = 0
            params.topMargin = 12
            if (layoutQuestionContainerLastView != null) {
                params.addRule(RelativeLayout.BELOW, layoutQuestionContainerLastView.id)
                rowQuestion.layoutParams = params
                val paramsT = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
                val textView: TextView? = TextView(requireContext())
                textView?.layoutParams = paramsT
                if (textView != null) {
                    textView.text = list[i - 1]
                    textView.textSize= convertToPixels(requireContext(), 6).toFloat()
                    textView.setTextColor(Color.WHITE)
                    textView.setBackgroundResource(R.drawable.button_grey2)
                    textView.gravity= Gravity.LEFT
                    textView.setOnClickListener {
                    }
                    rowQuestion.addView(textView)
                    layoutQuestionContainer.addView(rowQuestion, params)
                }
            } else {
                if (layoutQuestionContainerLastView != null) {
                    params.addRule(RelativeLayout.BELOW, layoutQuestionContainerLastView.id)
                }
                rowQuestion.layoutParams = params
                val paramsT = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
                val textView: TextView? = TextView(requireContext())
                textView?.layoutParams = paramsT
                if (textView != null) {
                    textView.text = list[i - 1]
                    textView.textSize= convertToPixels(requireContext(), 6).toFloat()
                    textView.setTextColor(Color.WHITE)
                    textView.setBackgroundResource(R.drawable.button_grey2)
                    textView.gravity= Gravity.LEFT
                    textView.setOnClickListener {
                    }
                    rowQuestion.addView(textView)
                    layoutQuestionContainer.addView(rowQuestion, params)
                }
            }
        }
    }

}