package home.product.searchjob2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import home.product.core.database.MainEntity
import home.product.core.database.repository.DataBaseRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadViewModel @Inject constructor( val repository: DataBaseRepository) : ViewModel() {
    private val _responseVacancies = MutableLiveData<List<MainEntity>>()
    val responseVacancies: LiveData<List<MainEntity>>
        get() = _responseVacancies

    fun loadFavoriteVacancies() {
        viewModelScope.launch {
            (repository.getAllVacancies().collect{_responseVacancies.postValue(it)})
        }
}
}