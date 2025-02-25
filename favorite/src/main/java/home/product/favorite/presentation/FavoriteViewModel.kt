package home.product.favorite.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.product.core.database.MainEntity
import home.product.core.database.repository.DataBaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(val repository: DataBaseRepository) : ViewModel() {
    private val _responseVacancies = MutableLiveData<List<MainEntity>>()
    val responseVacancies: LiveData<List<MainEntity>>
        get() = _responseVacancies

    fun loadFavoriteVacancies() {
        viewModelScope.launch {
            _responseVacancies.postValue(repository.getAllVacancies())
        }
    }
    fun saveVacancy(vacancy:MainEntity){
        viewModelScope.launch {
            repository.saveVacancies(vacancy)
        }
    }
    fun deleteVacancy(vacancy: MainEntity){
        viewModelScope.launch {
            repository.deleteVacancies(vacancy.title)
        }
    }
}