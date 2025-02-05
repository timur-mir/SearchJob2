package home.product.vacancies.domain

import home.product.vacancies.domain.entities.OffersWorkCompaniesDto

interface OffersWorkCompaniesRepository {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit)
}