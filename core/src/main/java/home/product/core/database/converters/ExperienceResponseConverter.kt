package home.product.core.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import home.product.core.response.ExperienceResponse


class ExperienceResponseConverter {
    private val gson: Gson by lazy { Gson() }
    @TypeConverter
    fun toExperienceResponse(jsonExperienceResponse: String): ExperienceResponse {
//        if(jsonExperienceResponse==null)
//            return null
        val notesType = object : TypeToken<ExperienceResponse>() {}.type
        return gson.fromJson(jsonExperienceResponse, notesType) as ExperienceResponse
    }
    @TypeConverter
    fun fromExperienceResponseGson(experienceResponse: ExperienceResponse): String {
//        if (experienceResponse == null)
//            return null
        val notesType = object : TypeToken<ExperienceResponse>() {}.type
        return gson.toJson(experienceResponse, notesType)


    }
}