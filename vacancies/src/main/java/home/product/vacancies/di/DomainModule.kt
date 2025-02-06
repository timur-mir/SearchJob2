package home.product.vacancies.di

import dagger.Module
import dagger.Provides
import home.product.vacancies.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.product.vacancies.domain.GetOffersWorkCompaniesUseCase

@Module
class DomainModule {
    @Provides
    fun provideGetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository: OffersWorkVacanciesImpl): GetOffersWorkCompaniesUseCase {
        return GetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository)
    }
}