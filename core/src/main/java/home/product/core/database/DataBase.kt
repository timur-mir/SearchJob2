package home.product.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import home.product.core.database.DataBase.Companion.DB_VERSION
import home.product.core.database.converters.AddressConverter
import home.product.core.database.converters.ExperienceResponseConverter
import home.product.core.database.converters.QuestionsConverter
import home.product.core.database.converters.SalaryResponseConverter
import home.product.core.database.converters.SchedulesConverter


@Database(
    entities = [MainEntity::class],
    version = DB_VERSION
)
abstract class DataBase : RoomDatabase(){
    @TypeConverters(AddressConverter::class,ExperienceResponseConverter::class,QuestionsConverter::class,
    SalaryResponseConverter::class,SchedulesConverter::class)
    abstract fun getFavoriteDao() :MainDao
    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "VacanciesBase"
    }
}