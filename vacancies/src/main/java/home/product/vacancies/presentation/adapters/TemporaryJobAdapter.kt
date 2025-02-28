package home.product.vacancies.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import home.product.vacancies.databinding.TemporaryJobListBinding
import home.product.vacancies.domain.entities.OffersMain


class TemporaryJobAdapter (private val OnItemClick: (link: String) -> Unit):
    AbsListItemAdapterDelegate<OffersMain.TemporaryJob, OffersMain, TemporaryJobAdapter.TemporaryJobAdapterHolder>() {
    class TemporaryJobAdapterHolder  (val binding: TemporaryJobListBinding): RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: OffersMain,
        items: MutableList<OffersMain>,
        position: Int
    ): Boolean {
        return item is OffersMain.TemporaryJob
    }

    override fun onCreateViewHolder(parent: ViewGroup): TemporaryJobAdapterHolder {
        return TemporaryJobAdapterHolder (
            TemporaryJobListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(
        item: OffersMain.TemporaryJob,
        holder: TemporaryJobAdapterHolder,
        payloads: MutableList<Any>
    ) {
        with(holder.binding) {
          temporaryJob.text = item.title.toString().trim()
            holder.binding.root.setOnClickListener {
                OnItemClick(item.link.toString())
            }
        }
    }

}
