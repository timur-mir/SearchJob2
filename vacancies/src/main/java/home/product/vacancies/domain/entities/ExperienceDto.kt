package home.howework.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ExperienceDto(
    var previewText: String,
    var text: String
):Parcelable
