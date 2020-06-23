package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Point(
    @Expose @SerializedName("point_lat") val pointLat: Double,
    @Expose @SerializedName("point_lng") val pointLng: Double
)