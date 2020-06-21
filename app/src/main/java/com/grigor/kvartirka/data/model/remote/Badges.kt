package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Badges(
    @SerializedName("more_than_year")
    val moreThanYear: Boolean,
    @SerializedName("owner_confirmed")
    val ownerConfirmed: Boolean,
    val payed: Int
)