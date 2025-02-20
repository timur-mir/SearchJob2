package home.product.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import home.product.core.database.converters.AddressConverter
import home.product.core.database.converters.ExperienceResponseConverter
import home.product.core.database.converters.QuestionsConverter
import home.product.core.database.converters.SalaryResponseConverter
import home.product.core.database.converters.SchedulesConverter
import home.product.core.response.AddressResponse
import home.product.core.response.ExperienceResponse
import home.product.core.response.SalaryResponse
@TypeConverters(AddressConverter::class,ExperienceResponseConverter::class,SalaryResponseConverter::class,SchedulesConverter::class,QuestionsConverter::class)
@Entity(tableName = "favorite")
data class MainEntity (
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var lookingNumber: Int=0,
    var title: String,
    var address: AddressResponse,
    var company: String,
    var experience: ExperienceResponse,
    var publishedDate: String,
    var isFavorite: Boolean,
    var salary: SalaryResponse,
    var schedules: ArrayList<String> = arrayListOf(),
    var appliedNumber    : Int,
    var description: String?,
    var responsibilities: String,
    var questions: ArrayList<String> = arrayListOf()
        )