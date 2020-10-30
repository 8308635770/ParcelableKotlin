package com.example.parcelablekotlin

import android.os.Parcel
import android.os.Parcelable



data class Student(val imageResource:Int, val name: String?, val surname: String?) : Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(imageResource)
        p0?.writeString(name)
        p0?.writeString(surname)
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}