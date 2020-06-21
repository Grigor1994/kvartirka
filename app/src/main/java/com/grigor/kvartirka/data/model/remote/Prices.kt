package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Prices(
    val day: Int,
    val hour: Int,
    val night: Int
)