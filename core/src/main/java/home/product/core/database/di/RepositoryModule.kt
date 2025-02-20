package home.product.core.database.di

import dagger.Binds
import dagger.Module
import home.product.core.database.MainDao
import home.product.core.database.repository.DataBaseRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
    internal abstract fun bindDataBaseRepository(dataBaseRepository:DataBaseRepository):DataBaseRepository
}