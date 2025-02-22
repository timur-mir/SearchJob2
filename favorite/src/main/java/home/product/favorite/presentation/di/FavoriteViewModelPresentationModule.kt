package home.product.favorite.presentation.di

import dagger.Module
import dagger.Provides
import home.product.core.database.repository.DataBaseRepository
import home.product.favorite.presentation.FavoriteViewModel

@Module
class FavoriteViewModelPresentationModule {
    @Provides
    fun provideFavoriteViewModel(dataBaseRepository: DataBaseRepository):FavoriteViewModel{
        return FavoriteViewModel(dataBaseRepository)
    }
}