package home.product.core.database.di

import android.content.Context
import dagger.Component
import home.product.core.database.MainDao
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        DataBaseModule::class,
        RepositoryModule::class]
)
interface CoreComponent {
    fun context(): Context
    fun mainDao(): MainDao
}