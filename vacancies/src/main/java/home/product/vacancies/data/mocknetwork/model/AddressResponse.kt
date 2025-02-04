package home.howework.data.mocknetwork.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
data class AddressResponse(
    @SerializedName("town")
   var town: String,
    @SerializedName("street")
    var street: String,
    @SerializedName("house")
    var house: String
)