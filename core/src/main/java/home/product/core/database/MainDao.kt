package home.product.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertVacancies(vacancies: MainEntity)
    @Transaction
    @Query("SELECT * FROM ${"favorite"} ")
    suspend  fun getAllVacancies():List<MainEntity>

    @Query("SELECT * FROM ${"favorite"} WHERE title LIKE :vacancies")
    suspend fun getMainEntity(vacancies: String): MainEntity

    @Query("DELETE FROM ${"favorite"} WHERE title= :vacancies")
    suspend  fun deleteOldInfo(vacancies: String)

}