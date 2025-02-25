package home.product.favorite.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import home.product.core.database.MainEntity
import home.product.favorite.R
import home.product.favorite.databinding.FavoriteListBinding

class FavoriteAdapter(private val OnClick: (MainEntity) -> Unit) :
    ListAdapter<MainEntity, FavoriteAdapter.FavoriteVacanciesHolder>(DiffUtilCallbackFavoriteVacancies()){
    class FavoriteVacanciesHolder(val binding: FavoriteListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVacanciesHolder {
        return FavoriteVacanciesHolder (
            FavoriteListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: FavoriteVacanciesHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            if (item.lookingNumber % 10 == 2 || item.lookingNumber % 10 == 3 || item.lookingNumber % 10 == 4) {
                lookCaptionFavorite.text = "Сейчас просматривают ${item.lookingNumber.toString()} человека"
            } else {
                lookCaptionFavorite.text = "Сейчас просматривает ${item.lookingNumber.toString()} человек"
            }
            if (item.isFavorite) {
                isFavoriteFavorite1.setImageResource(R.drawable.heart)
            } else {
                isFavoriteFavorite1.setImageResource(R.drawable.heart2)
            }
            isFavoriteFavorite1.setOnClickListener {
                if (item.isFavorite) {
                    isFavoriteFavorite1.setImageResource(R.drawable.heart)
                } else {
                    isFavoriteFavorite1.setImageResource(R.drawable.heart2)
                }
            }
            vacanctCaptionFavorite.text = item.title
            townVacantFavorite.text = item.address.town.toString()
            portfolioCaptionFavorite.text = item.experience.text.toString()
            publishedTimeFavorite.text = "Опубликовано ${item.publishedDate.toString()}"
            respondFavorite.setOnClickListener {

            }
            holder.binding.root.setOnClickListener {
                if (item.isFavorite) {
                 OnClick(item.copy(isFavorite=true))}
                else
                {
                    OnClick(item.copy(isFavorite=false))
                }
            }

        }

    }
    }



class DiffUtilCallbackFavoriteVacancies: DiffUtil.ItemCallback<MainEntity>() {
    override fun areItemsTheSame(oldItem: MainEntity, newItem: MainEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MainEntity, newItem: MainEntity): Boolean =
        oldItem == newItem
}
