package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Phone(
    @Expose @SerializedName("normalized") val normalized: String,
    @Expose @SerializedName("phone") val phone: String
) : Parcelable