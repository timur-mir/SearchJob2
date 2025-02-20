package home.product.core.response

import com.google.gson.annotations.SerializedName



data class VacanciesResponse(
    @SerializedName("id")
    var id: String,
    @SerializedName("lookingNumber")
    var lookingNumber: Int=0,
    @SerializedName("title")
    var title: String,
    @SerializedName("address")
    var address: AddressResponse,
    @SerializedName("company")
    var company: String,
    @SerializedName("experience")
    var experience: ExperienceResponse,
    @SerializedName("publishedDate")
    var publishedDate: String,
    @SerializedName("isFavorite")
    var isFavorite: Boolean,
    @SerializedName("salary")
    var salary: SalaryResponse,
    @SerializedName("schedules")
    var schedules: ArrayList<String> = arrayListOf(),
    @SerializedName("appliedNumber")
    var appliedNumber    : Int,
    @SerializedName("description")
    var description: String?,
    @SerializedName("responsibilities")
    var responsibilities: String,
    @SerializedName("questions")
    var questions: ArrayList<String> = arrayListOf()
)