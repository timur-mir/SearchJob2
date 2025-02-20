package home.product.core.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Arrays

import java.util.stream.Collectors

class SchedulesConverter {
    @TypeConverter
    fun fromSchedulesString(schedules: List<String>): String {
       // return schedules.stream().collect(Collectors.joining(","))
        val gson = Gson()
        return gson.toJson(schedules)
    }

    @TypeConverter
    fun toSchedulesList(data: String): List<String> {
//        return Arrays.asList(*data.split(",".toRegex()).dropLastWhile { it.isEmpty() }
//            .toTypedArray())
    //    return kotlin.collections.ArrayList(data.split(","))
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, listType)

    }
}