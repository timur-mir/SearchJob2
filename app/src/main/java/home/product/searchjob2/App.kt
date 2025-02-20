package home.product.searchjob2

import android.app.Application
import android.content.Context
import dagger.android.DaggerApplication
import home.product.core.database.di.ContextModule
import home.product.core.database.di.CoreComponent
import home.product.core.database.di.DaggerCoreComponent
import home.product.core.database.di.DaggerCoreComponent.builder
import home.product.searchjob2.di.AppComponent
import home.product.searchjob2.di.DaggerAppComponent
//import home.product.vacancies.di.VacanciesComponent


class App : Application() {

    lateinit var coreComponent: CoreComponent
    companion object {
          @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as? App)?.coreComponent
    }
    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
       initAppComponent()
    }
    private fun initAppComponent() {
   DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }
    private fun  initCoreDependencyInjection()  {
        coreComponent=DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

}