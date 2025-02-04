package home.howework.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AddressDto(
   var town: String,
    var street: String,
    var house: String
):Parcelable