package home.product.searchjob2.di

import android.app.Application
import android.app.NativeActivity
import dagger.Component
import home.product.core.database.di.CoreComponent
import home.product.searchjob2.App
import home.product.searchjob2.presentation.MainActivity

import javax.inject.Singleton

@AppScope
@Component(modules = [PresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(application: App)
    fun inject2(activity: MainActivity)
}