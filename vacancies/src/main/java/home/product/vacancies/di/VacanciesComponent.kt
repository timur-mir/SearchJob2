package home.product.vacancies.di


import dagger.Component
import home.product.core.database.di.CoreComponent
import home.product.searchjob2.di.FeatureScope
import home.product.vacancies.presentation.FullVacanciesFragment

import home.product.vacancies.presentation.MainViewModelFactory
import home.product.vacancies.presentation.SearchVacanciesFragment
import javax.inject.Singleton

@FeatureScope
@Component(
    modules = [
     home.product.vacancies.di.RepoModule::class,
        home.product.vacancies.di.DomainModule::class,
    home.product.vacancies.di.PresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface VacanciesComponent {
//    fun inject(searchVacanciesFragment: SearchVacanciesFragment)
fun inject(searchVacanciesFragment: SearchVacanciesFragment)
    fun inject2(fullVacanciesFragment: FullVacanciesFragment)
//fun mainViewModelFactory(): MainViewModelFactory
}