package home.product.vacancies.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import home.product.vacancies.domain.entities.OffersMain


class OffersMainAdapter(private val OnItemClick: (link:String) -> Unit):
    AsyncListDifferDelegationAdapter<OffersMain>(OffersMainDiffUtil()) {

    init {
            delegatesManager.addDelegate(VacanciesNearAdapterDelegate(OnItemClick))
                .addDelegate(RaiseResumeAdapter(OnItemClick))
                .addDelegate(TemporaryJobAdapter(OnItemClick))
    }

    class OffersMainDiffUtil : DiffUtil.ItemCallback<OffersMain>() {
        override fun areItemsTheSame(oldItem: OffersMain, newItem: OffersMain): Boolean {
            return when {
                oldItem is OffersMain.VacanciesNear && newItem is OffersMain.VacanciesNear -> oldItem.id == newItem.id
                oldItem is OffersMain.ResumeRaise && newItem is OffersMain.ResumeRaise -> oldItem.id == newItem.id
                oldItem is OffersMain.TemporaryJob && newItem is OffersMain.TemporaryJob -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: OffersMain, newItem: OffersMain): Boolean {
            return oldItem == newItem
        }
    }
}