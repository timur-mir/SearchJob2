package home.product.vacancies.di

import dagger.Module
import dagger.Provides
import home.product.core.database.DataBase
import home.product.core.database.MainDao
import home.product.core.database.di.CoreComponent
import home.product.core.database.di.DataBaseModule

import home.product.core.database.repository.DataBaseRepository
import home.product.vacancies.domain.GetOffersWorkCompaniesUseCase
import home.product.vacancies.presentation.MainViewModel

@Module
class PresentationModule {
    @Provides
    fun provideMainViewModel(offersWorkCompaniesUseCase: GetOffersWorkCompaniesUseCase,dataBaseRepository: DataBaseRepository):MainViewModel{
        return MainViewModel(offersWorkCompaniesUseCase,dataBaseRepository )
    }
}