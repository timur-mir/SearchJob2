package home.product.vacancies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.product.core.database.MainEntity
import home.product.core.database.repository.DataBaseRepository
import home.product.vacancies.data.mapToMainEntity
import home.product.vacancies.domain.GetOffersWorkCompaniesUseCase
import home.product.vacancies.domain.entities.OffersMain
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import home.product.vacancies.domain.entities.VacanciesDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val remoteMockRepo: GetOffersWorkCompaniesUseCase,
    val repository: DataBaseRepository
) : ViewModel() {

    val data = OffersWorkCompaniesDto()
    private val _responseOffersVacancies = MutableStateFlow<OffersWorkCompaniesDto>(
        data
    )
    val responseOffersVacancies = _responseOffersVacancies.asStateFlow()
    val data2 = ArrayList<OffersMain>()

    private val _responseOffersMain = MutableStateFlow<List<OffersMain>>(
        data2
    )
    val responseOffersOffersMain = _responseOffersMain.asStateFlow()
    fun saveInFavorite(favoriteVacance:VacanciesDto){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveVacancies(favoriteVacance.mapToMainEntity())
        }
    }
    fun deleteVacancy(vacancy: VacanciesDto){
        viewModelScope.launch {
            repository.deleteVacancies(vacancy.title)
        }
    }

    fun getOffersVacancies() {
        viewModelScope.launch {

            remoteMockRepo.getOffersVacancies { objectInfo ->
               // launch {   repository.saveVacancies(objectInfo.vacancies[0].mapToMainEntity()) }

                _responseOffersVacancies.value = objectInfo
                val offersMain: MutableList<OffersMain> = mutableListOf(
                    OffersMain.VacanciesNear(
                        id = objectInfo.offers[0].id.toString(),
                        title = objectInfo.offers[0].title.toString(),
                        link = objectInfo.offers[0].link.toString(),
                    ),
                    OffersMain.ResumeRaise(
                        id = objectInfo.offers[1].id.toString(),
                        title = objectInfo.offers[1].title.toString(),
                        link = objectInfo.offers[1].link.toString(),
                    ),

                    OffersMain.TemporaryJob(
                        id = objectInfo.offers[2].id.toString(),
                        title = objectInfo.offers[2].title.toString(),
                        link = objectInfo.offers[2].link.toString(),
                    )
                )
                _responseOffersMain.value = offersMain
            }

        }
    }
}



