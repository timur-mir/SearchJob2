package home.howework.data.mocknetwork.model

import com.google.gson.annotations.SerializedName

data class OffersResponse (
     @SerializedName("id")
     var id    : String?,
     @SerializedName("title")
     var title : String?,
     @SerializedName("link")
     var link  : String?
)