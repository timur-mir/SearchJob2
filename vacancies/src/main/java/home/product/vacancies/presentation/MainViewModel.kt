package home.product.vacancies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.product.vacancies.domain.GetOffersWorkCompaniesUseCase
import home.product.vacancies.domain.entities.OffersMain
import home.product.vacancies.domain.entities.OffersWorkCompaniesDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val remoteMockRepo: GetOffersWorkCompaniesUseCase
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

    fun getOffersVacancies() {
        viewModelScope.launch {
            remoteMockRepo.getOffersVacancies { objectInfo ->
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



