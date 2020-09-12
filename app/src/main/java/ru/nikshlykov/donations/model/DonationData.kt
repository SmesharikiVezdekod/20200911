package ru.nikshlykov.donations.model

import android.os.Parcel
import android.os.Parcelable

data class DonationData(
        var type: Int = TYPE_ONE_TIME,
        var title: String = "",
        var sumRubles: Double = 0.0,
        var aim: String = "",
        var description: String = "",
        var moneyReceivingAccount: String = "",
        var author: String = "",
        var deadline: Int = DEADLINE_FULL_SUM,
        var deadlineDate: String = "",
        var currentSumRubles: Double = 0.0
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.safeString(),
            parcel.readDouble(),
            parcel.safeString(),
            parcel.safeString(),
            parcel.safeString(),
            parcel.safeString(),
            parcel.readInt(),
            parcel.safeString(),
            parcel.readDouble())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(type)
        parcel.writeString(title)
        parcel.writeDouble(sumRubles)
        parcel.writeString(aim)
        parcel.writeString(description)
        parcel.writeString(moneyReceivingAccount)
        parcel.writeString(author)
        parcel.writeInt(deadline)
        parcel.writeString(deadlineDate)
        parcel.writeDouble(currentSumRubles)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DonationData> {
        override fun createFromParcel(parcel: Parcel): DonationData {
            return DonationData(parcel)
        }

        override fun newArray(size: Int): Array<DonationData?> {
            return arrayOfNulls(size)
        }


        const val TYPE_ONE_TIME = 0
        const val TYPE_REPETITIVE = 1

        const val DEADLINE_FULL_SUM = 0
        const val DEADLINE_CERTAIN_DATE = 1

        private fun Parcel.safeString(default: String = "") = readString() ?: default
    }
}