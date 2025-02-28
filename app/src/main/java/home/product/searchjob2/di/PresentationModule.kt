package home.product.searchjob2.di

import dagger.Module
import dagger.Provides
import home.product.core.database.repository.DataBaseRepository
import home.product.searchjob2.presentation.HeadViewModel

@Module
class PresentationModule {
    @Provides
    fun provideHeadViewModel(dataBaseRepository: DataBaseRepository): HeadViewModel {
        return HeadViewModel(dataBaseRepository )
    }
}