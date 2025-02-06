package home.product.vacancies.di


import dagger.Component
import home.product.vacancies.presentation.MainViewModelFactory
import home.product.vacancies.presentation.SearchVacanciesFragment
import javax.inject.Singleton

@FeatureScope
@Singleton
@Component(
    modules = [
     home.product.vacancies.di.RepoModule::class,
        home.product.vacancies.di.DomainModule::class,
    ]
)
interface VacanciesComponent {
//    fun inject(searchVacanciesFragment: SearchVacanciesFragment)
fun mainViewModelFactory(): MainViewModelFactory
}