package home.product.core.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import home.product.core.response.AddressResponse

class AddressConverter {
  //  private val gson: Gson by lazy { Gson() }
    @TypeConverter
    fun toAddressResponse(jsonAddressResponse: String): AddressResponse {
//        if(jsonAddressResponse==null)
//            return null
      val gson = Gson()
        val notesType = object : TypeToken<AddressResponse>() {}.type
        return gson.fromJson(jsonAddressResponse, notesType)
    }
    @TypeConverter
    fun fromAddressResponseGson(addressResponse: AddressResponse): String {
//        if (addressResponse == null)
//            return null
        val gson = Gson()
        val notesType = object : TypeToken<AddressResponse>() {}.type
        return gson.toJson(addressResponse, notesType)


    }
}