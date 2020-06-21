package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Point(
    @SerializedName("point_lat")
    val pointLat: Double,
    @SerializedName("point_lng")
    val pointLng: Double
)