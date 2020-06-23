package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoDefault(
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("verified") val verified: Boolean,
    @Expose @SerializedName("width") val width: Int
) : Parcelable