package home.product.vacancies.domain

import home.howework.domain.entities.OffersWorkCompaniesDto
import home.product.vacancies.data.mocknetwork.repository.OffersWorkVacanciesImpl

class GetOffersWorkCompaniesUseCase () {

    val offersWorkCompaniesRepository:OffersWorkCompaniesRepository=OffersWorkVacanciesImpl()
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
        return offersWorkCompaniesRepository.getOffersVacancies(){
            callback(it)
        }
    }
}