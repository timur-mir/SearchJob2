package home.product.vacancies.presentation.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import home.product.vacancies.R
import home.product.vacancies.databinding.ListVacanciesConlayoutBinding
import home.product.vacancies.domain.entities.VacanciesDto
import home.product.vacancies.presentation.helpScopeReference
import home.product.vacancies.presentation.helpScopeReference.cardScopeTurnButton

class VacanciesAdapter(private val OnClick: (VacanciesDto) -> Unit) :
    ListAdapter<VacanciesDto, VacanciesHolder>(DiffUtilCallbackVacancies()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesHolder {
        return VacanciesHolder(
            ListVacanciesConlayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: VacanciesHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            if (item.lookingNumber % 10 == 2 || item.lookingNumber % 10 == 3 || item.lookingNumber % 10 == 4) {
                lookCaption1.text = "Сейчас просматривают ${item.lookingNumber.toString()} человека"
            } else {
                lookCaption1.text = "Сейчас просматривает ${item.lookingNumber.toString()} человек"
            }
            if (item.isFavorite) {
                isFavorite1.setImageResource(R.drawable.heart)
            } else {
                isFavorite1.setImageResource(R.drawable.heart2)
            }

            isFavorite1.setOnClickListener {
                helpScopeReference.turnButton = !helpScopeReference.turnButton
                if (helpScopeReference.turnButton) {
                    isFavorite1.setImageResource(R.drawable.heart)
                    OnClick(item.copy(isFavorite = true))
                } else {
                    isFavorite1.setImageResource(R.drawable.heart2)
                    OnClick(item.copy(isFavorite = false))
                }
            }

            vacancyCaption1.text = item.title
            townVacant1.text = item.address.town.toString()
            portfolioCaption1.text = item.experience.previewText
            publishedTime1.text = "Опубликовано ${item.publishedDate.toString()}"
            respond.setOnClickListener {

            }
            holder.binding.root.setOnClickListener {
                cardScopeTurnButton = true
                //OnClick(item) }
                if (helpScopeReference.turnButton) {
                    isFavorite1.setImageResource(R.drawable.heart)
                    OnClick(item.copy(isFavorite = true))
                } else {
                    isFavorite1.setImageResource(R.drawable.heart2)
                    OnClick(item.copy(isFavorite = false))
                }
            }
        }

        }

    }




class DiffUtilCallbackVacancies : DiffUtil.ItemCallback<VacanciesDto>() {
    override fun areItemsTheSame(oldItem: VacanciesDto, newItem: VacanciesDto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VacanciesDto, newItem: VacanciesDto): Boolean =
        oldItem == newItem
}

class VacanciesHolder(val binding: ListVacanciesConlayoutBinding) : RecyclerView.ViewHolder(binding.root)