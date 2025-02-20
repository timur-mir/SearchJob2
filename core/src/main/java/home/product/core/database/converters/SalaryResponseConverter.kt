package home.product.core.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import home.product.core.response.SalaryResponse

class SalaryResponseConverter {
    private val gson: Gson by lazy { Gson() }
    @TypeConverter
    fun toSalaryResponse(jsonSalaryResponse: String): SalaryResponse {
//        if(jsonSalaryResponse==null)
          //  return null
        val notesType = object : TypeToken<SalaryResponse>() {}.type
        return gson.fromJson(jsonSalaryResponse, notesType) as SalaryResponse
    }
    @TypeConverter
    fun fromSalaryResponseGson(salaryResponse: SalaryResponse): String {
//        if (salaryResponse == null)
//            return null
        val notesType = object : TypeToken<SalaryResponse>() {}.type
        return gson.toJson(salaryResponse, notesType)


    }
}