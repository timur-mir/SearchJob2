package home.product.vacancies.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import home.product.vacancies.presentation.useresponse.ResponseDialogFragment
import home.product.vacancies.data.utilits.convertToPixels
import home.product.vacancies.R
import home.product.vacancies.databinding.DetailFragmentBinding


class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg: DetailFragmentArgs by navArgs()
        binding.isBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.responseClickButton.setOnClickListener {
            val responseDialogFragmentDialog = ResponseDialogFragment()
            fragmentManager?.let { it1 -> responseDialogFragmentDialog.show(it1, "dialog...") }
        }
        if (arg.aboutVacancy.appliedNumber != 0) {
            if (arg.aboutVacancy.appliedNumber == 1 && arg.aboutVacancy.appliedNumber != 11)
                binding.appliedNumber.text =
                    "${arg.aboutVacancy.appliedNumber.toString()} человек уже откликнулся"
            else
                binding.appliedNumber.text =
                    "${arg.aboutVacancy.appliedNumber.toString()} человек уже откликнулось"
        }
        if (arg.aboutVacancy.lookingNumber != 0) {
            if (arg.aboutVacancy.lookingNumber % 10 == 2 || arg.aboutVacancy.lookingNumber % 10 == 3 || arg.aboutVacancy.lookingNumber % 10 == 4) {
                binding.lookedSome.text =
                    "${arg.aboutVacancy.lookingNumber.toString()} человека сейчас смотрят"
            } else {
                binding.lookedSome.text =
                    "${arg.aboutVacancy.lookingNumber.toString()} человек сейчас смотрит"
            }
        }
        if (arg.aboutVacancy.isFavorite) {
            binding.isFavourite.setImageResource(R.drawable.heart)
        } else {
            binding.isFavourite.setImageResource(R.drawable.heart2)
        }

        binding.lookedSome
        binding.vacancy.text = arg.aboutVacancy.title
        binding.salary.text = arg.aboutVacancy.salary.full
        binding.expirience.text = arg.aboutVacancy.experience.text
        binding.shedules.text = arg.aboutVacancy.schedules.joinToString(",") { it.toString() }
        binding.companyCaption.text = arg.aboutVacancy.company
        binding.companyAddress.text =
            "${arg.aboutVacancy.address.town} , ${arg.aboutVacancy.address.street} , ${arg.aboutVacancy.address.house}"
        ///////////////////////////////
        binding.aboutCompany.text = arg.aboutVacancy.description
        ///////////////////////////////
        binding.youTasks.text = arg.aboutVacancy.responsibilities
        //////////////////////////////
        createQuestionView(arg.aboutVacancy.questions)
    }

    private fun createQuestionView(list: ArrayList<String>) {
        val listSize = list.size
        val layoutQuestionContainer = binding.questionContainer
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
                    textView.gravity=Gravity.LEFT
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
                    textView.gravity=Gravity.LEFT
                    textView.setOnClickListener {
                    }
                    rowQuestion.addView(textView)
                    layoutQuestionContainer.addView(rowQuestion, params)
                }
            }
        }
    }

}

