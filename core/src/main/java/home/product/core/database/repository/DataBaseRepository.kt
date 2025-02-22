package home.product.core.database.repository

import home.product.core.database.MainDao
import home.product.core.database.MainEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import javax.inject.Inject
import javax.inject.Singleton

class DataBaseRepository @Inject constructor(private val dao:MainDao) {
    @OptIn(DelicateCoroutinesApi::class)
    val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun saveVacancies(data:MainEntity){
        dao.insertVacancies(data)
    }
    suspend fun deleteVacancies(title:String){
        dao.deleteOldInfo(title)
    }
    suspend fun getAllVacancies()=withContext(scope.coroutineContext){
       dao.getAllVacancies()
    }
}