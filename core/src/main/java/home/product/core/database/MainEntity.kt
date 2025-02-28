package home.product.core.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import home.product.core.database.converters.AddressConverter
import home.product.core.database.converters.ExperienceResponseConverter
import home.product.core.database.converters.QuestionsConverter
import home.product.core.database.converters.SalaryResponseConverter
import home.product.core.database.converters.SchedulesConverter
import home.product.core.response.AddressResponse
import home.product.core.response.ExperienceResponse
import home.product.core.response.SalaryResponse
@TypeConverters(AddressConverter::class,ExperienceResponseConverter::class,SalaryResponseConverter::class,SchedulesConverter::class,QuestionsConverter::class)
@Entity(tableName = "favorite")
data class MainEntity (
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var lookingNumber: Int=0,
    var title: String,
    var address: AddressResponse,
    var company: String,
    var experience: ExperienceResponse,
    var publishedDate: String,
    var isFavorite: Boolean,
    var salary: SalaryResponse,
    var schedules: ArrayList<String> = arrayListOf(),
    var appliedNumber    : Int,
    var description: String?,
    var responsibilities: String,
    var questions: ArrayList<String> = arrayListOf()
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        TODO("address"),
        parcel.readString().toString(),
        TODO("experience"),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        TODO("salary"),
        TODO("schedules"),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString().toString(),
        TODO("questions")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeInt(lookingNumber)
        parcel.writeString(title)
        parcel.writeString(company)
        parcel.writeString(publishedDate)
        parcel.writeByte(if (isFavorite) 1 else 0)
        parcel.writeInt(appliedNumber)
        parcel.writeString(description)
        parcel.writeString(responsibilities)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainEntity> {
        override fun createFromParcel(parcel: Parcel): MainEntity {
            return MainEntity(parcel)
        }

        override fun newArray(size: Int): Array<MainEntity?> {
            return arrayOfNulls(size)
        }
    }
}