package home.product.vacancies.di

import dagger.Module
import dagger.Provides
import home.product.vacancies.data.mocknetwork.network.NetworkServiceClient
import home.product.vacancies.data.mocknetwork.repository.OffersWorkVacanciesImpl

@Module
class RepoModule {
@Provides
fun provideNetworkServiceClient(): NetworkServiceClient {
    return NetworkServiceClient()
}
    @Provides
    fun provideOffersWorkVacanciesImpl(): OffersWorkVacanciesImpl {
        return OffersWorkVacanciesImpl(NetworkServiceClient())
    }
}