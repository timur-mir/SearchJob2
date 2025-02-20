package home.product.core.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName



data class SalaryResponse (
    @SerializedName("full")
    var full : String
)