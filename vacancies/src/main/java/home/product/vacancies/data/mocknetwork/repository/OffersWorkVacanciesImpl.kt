package home.product.vacancies.data.mocknetwork.repository

import android.util.Log
import home.howework.data.mocknetwork.model.OffersWorkCompaniesResponse
import home.product.vacancies.data.mapToOffersWorkCompaniesDto
import home.product.vacancies.data.mocknetwork.network.NetworkServiceClient
import home.product.vacancies.domain.OffersWorkCompaniesRepository
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OffersWorkVacanciesImpl() :
    OffersWorkCompaniesRepository {
    private val networkServiceClient: NetworkServiceClient = NetworkServiceClient()
    override suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto) -> Unit) {
        networkServiceClient.getMockRemoteDataSourceRepo().getOffersVacancies()
            .enqueue(object : Callback<OffersWorkCompaniesResponse> {
                override fun onResponse(
                    call: Call<OffersWorkCompaniesResponse>,
                    response: Response<OffersWorkCompaniesResponse>
                ) {
                    callback(response.body()!!.mapToOffersWorkCompaniesDto())
                }

                override fun onFailure(call: Call<OffersWorkCompaniesResponse>, t: Throwable) {
                    Log.e("Server", "execute request error = ${t.message}", t)
                }

            })
    }
}

