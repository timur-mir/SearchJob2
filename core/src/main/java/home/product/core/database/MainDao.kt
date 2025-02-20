package home.product.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertVacancies(vacancies: MainEntity)

    @Query("SELECT * FROM ${"favorite"} ")
    fun getAllVacancies():List<MainEntity>

    @Query("SELECT * FROM ${"favorite"} WHERE title LIKE :vacancies")
    fun getMainEntity(vacancies: String): List<MainEntity >

    @Query("DELETE FROM ${"favorite"} WHERE title= :vacancies")
  fun deleteOldInfo(vacancies: String)

}