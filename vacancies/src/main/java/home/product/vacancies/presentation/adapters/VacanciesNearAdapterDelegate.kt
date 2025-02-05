package home.product.vacancies.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import home.product.vacancies.databinding.VacanciesNearListBinding
import home.product.vacancies.domain.entities.OffersMain

class VacanciesNearAdapterDelegate(private val OnItemClick: (link: String) -> Unit):
    AbsListItemAdapterDelegate<OffersMain.VacanciesNear, OffersMain, VacanciesNearAdapterDelegate.VacanciesNearHolder>() {


    class VacanciesNearHolder(val binding: VacanciesNearListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: OffersMain,
        items: MutableList<OffersMain>,
        position: Int
    ): Boolean {
        return item is OffersMain.VacanciesNear
    }

    override fun onCreateViewHolder(parent: ViewGroup): VacanciesNearHolder {
        return VacanciesNearHolder(
            VacanciesNearListBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(
        item: OffersMain.VacanciesNear,
        holder: VacanciesNearHolder,
        payloads: MutableList<Any>
    ) {
        with(holder.binding) {
            vacanciesNear.text = item.title.toString()

            holder.binding.root.setOnClickListener {
                OnItemClick(item.link.toString())
            }
        }
    }
}