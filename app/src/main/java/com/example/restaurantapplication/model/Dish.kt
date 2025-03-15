package com.example.restaurantapplication.model

import android.os.Parcel
import android.os.Parcelable

data class Dish(
    val name: String,
    val price: Double,
    var quantity: Int = 0 // Quantity property
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readInt()
    )

    // Move these methods outside of the constructor block
    fun increaseQuantity() {
        quantity++
    }

    fun decreaseQuantity() {
        if (quantity > 0) quantity--
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(price)
        parcel.writeInt(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dish> {
        override fun createFromParcel(parcel: Parcel): Dish {
            return Dish(
                parcel.readString() ?: "",
                parcel.readDouble(),
                parcel.readInt()
            )
        }

        override fun newArray(size: Int): Array<Dish?> {
            return arrayOfNulls(size)
        }
    }
}
