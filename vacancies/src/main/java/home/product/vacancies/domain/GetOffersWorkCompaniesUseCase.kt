package home.product.vacancies.domain

import home.product.vacancies.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import javax.inject.Inject

class GetOffersWorkCompaniesUseCase @Inject constructor(private val offersWorkCompaniesRepository:OffersWorkCompaniesRepository) {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit){
        return offersWorkCompaniesRepository.getOffersVacancies(){
            callback(it)
        }
    }
}