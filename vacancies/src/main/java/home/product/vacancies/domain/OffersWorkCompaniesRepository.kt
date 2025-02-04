package home.product.vacancies.domain

import home.howework.domain.entities.OffersWorkCompaniesDto

interface OffersWorkCompaniesRepository {
    suspend fun getOffersVacancies(callback: (OffersWorkCompaniesDto)->Unit)
}