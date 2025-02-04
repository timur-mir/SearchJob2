package home.howework.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VacanciesDto(
    var id: String,
    var lookingNumber: Int=0,
    var title: String,
    var address: AddressDto,
    var company: String,
    var experience: ExperienceDto,
    var publishedDate: String,
    var isFavorite: Boolean,
    var salary: SalaryDto,
    var schedules: ArrayList<String> = arrayListOf(),
    var appliedNumber    : Int,
    var description: String?,
    var responsibilities: String,
    var questions: ArrayList<String> = arrayListOf()
):Parcelable