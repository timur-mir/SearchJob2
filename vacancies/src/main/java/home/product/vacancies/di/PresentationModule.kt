package home.product.vacancies.di

import dagger.Module
import dagger.Provides
import home.product.vacancies.domain.GetOffersWorkCompaniesUseCase
import home.product.vacancies.presentation.MainViewModel

@Module
class PresentationModule {
    @Provides
    fun provideMainViewModel(offersWorkCompaniesUseCase: GetOffersWorkCompaniesUseCase):MainViewModel{
        return MainViewModel(offersWorkCompaniesUseCase)
    }
}