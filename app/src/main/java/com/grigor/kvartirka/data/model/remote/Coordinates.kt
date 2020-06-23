package com.grigor.kvartirka.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Coordinates(
    @Expose @SerializedName("lat") val lat: Double,
    @Expose @SerializedName("lon") val lon: Double
) : Parcelable