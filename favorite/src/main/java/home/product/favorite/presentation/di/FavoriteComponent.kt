package home.product.favorite.presentation.di

import dagger.Component
import home.product.core.database.di.CoreComponent
import home.product.favorite.presentation.FavoriteFragment
import home.product.searchjob2.di.FeatureScope

@FeatureScope
@Component(
    modules = [
 FavoriteViewModelPresentationModule::class],
    dependencies = [CoreComponent::class]
)
interface FavoriteComponent {
    fun inject(favoriteFragment: FavoriteFragment)
}