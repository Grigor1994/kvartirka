package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class FlatResponse(
    @SerializedName("city_id")
    val cityId: Int,
    val currency: Currency,
    val flats: List<Flat>,
    val query: Query,
    val version: Double
)