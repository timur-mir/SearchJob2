package home.product.vacancies.domain

import home.product.vacancies.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto

class GetOffersWorkCompaniesUseCase () {

    val offersWorkCompaniesRepository:OffersWorkCompaniesRepository=OffersWorkVacanciesImpl()
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
        return offersWorkCompaniesRepository.getOffersVacancies(){
            callback(it)
        }
    }
}