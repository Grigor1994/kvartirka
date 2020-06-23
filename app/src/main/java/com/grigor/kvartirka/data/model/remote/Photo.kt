package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("verified") val verified: Boolean
) : Parcelable