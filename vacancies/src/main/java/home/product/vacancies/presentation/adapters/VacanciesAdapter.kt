package home.product.vacancies.presentation.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import home.product.vacancies.R


import home.product.vacancies.databinding.ListVacanciesBinding
import home.product.vacancies.domain.entities.VacanciesDto

class VacanciesAdapter(private val OnClick: (VacanciesDto) -> Unit) :
    ListAdapter<VacanciesDto, VacanciesHolder>(DiffUtilCallbackVacancies()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesHolder {
       return VacanciesHolder(
          ListVacanciesBinding.inflate(
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
            if(item.lookingNumber%10==2||item.lookingNumber%10==3||item.lookingNumber%10==4) {
                lookCaption.text="Сейчас просматривают ${item.lookingNumber.toString()} человека"
            }
            else {
                lookCaption.text="Сейчас просматривает ${item.lookingNumber.toString()} человек"
            }
           if( item.isFavorite){
               isFavorite.setImageResource(R.drawable.heart)
           }
            else{
               isFavorite.setImageResource(R.drawable.heart2)
            }

            vacanctCaption.text=item.title
            townVacant.text=item.address.town.toString()
            portfolioCaption.text=item.experience.text.toString()
            publishedTime.text="Опубликовано ${item.publishedDate.toString()}"
            respond.setOnClickListener{

            }
            holder.binding.root.setOnClickListener {
                OnClick(item)
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

class VacanciesHolder(val binding: ListVacanciesBinding) : RecyclerView.ViewHolder(binding.root)