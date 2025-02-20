package home.product.searchjob2.di

import android.app.Application
import dagger.Component
import home.product.core.database.di.CoreComponent
import home.product.searchjob2.App

import javax.inject.Singleton

@AppScope
@Component(
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(application: App)
}