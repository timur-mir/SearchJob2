package home.product.searchjob2.di

import android.app.Application
import dagger.Component
import home.product.searchjob2.App
import home.product.vacancies.di.VacanciesComponent
import javax.inject.Singleton

@AppScope
//@Singleton
@Component(
    dependencies = [VacanciesComponent::class]
)
interface AppComponent {
    fun inject(application: App)
}