package home.product.core.database.repository

import home.product.core.database.MainDao
import home.product.core.database.MainEntity
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class DataBaseRepository @Inject constructor(private val dao:MainDao) {
    suspend fun saveVacancies(data:MainEntity){
        dao.insertVacancies(data)
      suspend fun deleteVacancies(title:String){
            dao.deleteOldInfo(title)
        }
    }
}