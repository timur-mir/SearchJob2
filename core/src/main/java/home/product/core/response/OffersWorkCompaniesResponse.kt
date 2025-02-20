package home.product.core.response

import com.google.gson.annotations.SerializedName

data class OffersWorkCompaniesResponse(
    @SerializedName("offers")
      var offers    : ArrayList<OffersResponse> = arrayListOf(),
    @SerializedName("vacancies")
      var vacancies :ArrayList<VacanciesResponse> = arrayListOf()
)