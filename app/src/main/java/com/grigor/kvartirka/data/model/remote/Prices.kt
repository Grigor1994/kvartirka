package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prices(
    @Expose @SerializedName("day") val day: Int,
    @Expose @SerializedName("hour") val hour: Int,
    @Expose @SerializedName("night") val night: Int
) : Parcelable