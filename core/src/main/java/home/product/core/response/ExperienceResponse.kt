package home.product.core.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName




data class ExperienceResponse(
    @SerializedName("previewText")
    var previewText: String,
    @SerializedName("text")
    var text: String
)
