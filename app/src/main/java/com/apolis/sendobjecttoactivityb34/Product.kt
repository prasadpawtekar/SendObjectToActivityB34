package com.apolis.sendobjecttoactivityb34

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Product (
    val pName: String,
    val category: String,
    val price: Float,
    val userRating: Float
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pName)
        parcel.writeString(category)
        parcel.writeFloat(price)
        parcel.writeFloat(userRating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}