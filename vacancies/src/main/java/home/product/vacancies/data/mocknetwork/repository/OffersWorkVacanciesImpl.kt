package home.product.vacancies.data.mocknetwork.repository

import android.util.Log
import home.product.core.response.OffersWorkCompaniesResponse
import home.product.vacancies.data.mapToOffersWorkCompaniesDto
import home.product.vacancies.data.mocknetwork.network.NetworkServiceClient
import home.product.vacancies.domain.OffersWorkCompaniesRepository
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class OffersWorkVacanciesImpl @Inject constructor(private val networkServiceClient: NetworkServiceClient) :
    OffersWorkCompaniesRepository {
    override suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto) -> Unit) {
        networkServiceClient.getMockRemoteDataSourceRepo().getOffersVacancies()
            .enqueue(object : Callback<home.product.core.response.OffersWorkCompaniesResponse> {
                override fun onResponse(
                    call: Call<home.product.core.response.OffersWorkCompaniesResponse>,
                    response: Response<home.product.core.response.OffersWorkCompaniesResponse>
                ) {
                    callback(response.body()!!.mapToOffersWorkCompaniesDto())
                }

                override fun onFailure(call: Call<home.product.core.response.OffersWorkCompaniesResponse>, t: Throwable) {
                    Log.e("Server", "execute request error = ${t.message}", t)
                }

            })
    }
}

