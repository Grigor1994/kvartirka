package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlatResponse(
    @Expose @SerializedName("city_id") val cityId: Int,
    @Expose @SerializedName("currency") val currency: Currency,
    @Expose @SerializedName("flats") val flats: List<Flat>,
    @Expose @SerializedName("query") val query: Query,
    @Expose @SerializedName("version") val version: Double
)