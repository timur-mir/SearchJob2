package home.product.searchjob2

import android.app.Application
import android.content.Context
import home.product.searchjob2.di.DaggerAppComponent
import home.product.vacancies.di.DaggerVacanciesComponent
import home.product.vacancies.di.VacanciesComponent

import home.product.vacancies.di.VacanciesComponentProvider

class App : Application() {
    lateinit var vcComponent: VacanciesComponent
    companion object {
       // @JvmStatic
      //  fun vcComponentD(context: Context) =(context.applicationContext as? Application)?.vcComponent

    }
    override fun onCreate() {
        super.onCreate()
        initVcDependencyInjection()
        initAppComponent()

    }


    private fun initAppComponent() {
        DaggerAppComponent
            .builder()
            .vacanciesComponent(vcComponent)
            .build()
    }
    private fun initVcDependencyInjection() {
        vcComponent=DaggerVacanciesComponent
            .builder()
            .build()
    }

}