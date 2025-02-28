package home.product.vacancies.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import home.product.vacancies.databinding.ListVacanciesConlayoutBinding

class CustomViewVacancy@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAtrr:Int=0
): LinearLayout(context,attrs,defStyleAtrr) {
    private val cv=ListVacanciesConlayoutBinding.inflate(LayoutInflater.from(context))
    init {
        addView(cv.root)
    }
    fun setTextForLookingNumber(text:String){
        cv.lookCaption1.text=text
    }
    fun setImageForIsFavorite(imageRes:Int){
        cv.isFavorite1.setImageResource(imageRes)
    }
    fun setTextForVacancyCaption(text:String){
        cv.vacancyCaption1.text=text
    }
    fun setTextForTown(text:String){
        cv.townVacant1.text=text
    }
    fun setTextForPortfolio(text:String){
        cv.portfolioCaption1.text=text
    }
    fun setTextForPublishedTime(text:String){
        cv.publishedTime1.text=text
    }

}