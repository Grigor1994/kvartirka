package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Flat(
    val address: String,
    val badges: Badges,
    @SerializedName("building_type")
    val buildingType: String,
    @SerializedName("city_id")
    val cityId: Int,
    val contacts: Contacts,
    val coordinates: Coordinates,
    val description: String,
    @SerializedName("description_full")
    val descriptionFull: String,
    @SerializedName("distance_from_point_text")
    val distanceFromPointText: String,
    val id: Int,
    val metro: String,
    @SerializedName("photo_default")
    val photoDefault: PhotoDefault,
    val photos: List<Photo>,
    val prices: Prices,
    val rooms: Int,
    val title: String,
    val url: String
)