package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Badges(
    @Expose @SerializedName("more_than_year") val moreThanYear: Boolean,
    @Expose @SerializedName("owner_confirmed") val ownerConfirmed: Boolean,
    @Expose @SerializedName("payed") val payed: Int
) : Parcelable