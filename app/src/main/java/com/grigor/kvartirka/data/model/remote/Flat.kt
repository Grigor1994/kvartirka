package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flat(
    @Expose @SerializedName("address") val address: String,
    @Expose @SerializedName("badges") val badges: Badges,
    @Expose @SerializedName("building_type") val buildingType: String,
    @Expose @SerializedName("contacts") val contacts: Contacts,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("description_full") val descriptionFull: String,
    @Expose @SerializedName("metro") val metro: String,
    @Expose @SerializedName("photo_default") val photoDefault: PhotoDefault,
    @Expose @SerializedName("photos") val photos: List<Photo>,
    @Expose @SerializedName("prices") val prices: Prices,
    @Expose @SerializedName("rooms") val rooms: Int,
    @Expose @SerializedName("title") val title: String
) : Parcelable