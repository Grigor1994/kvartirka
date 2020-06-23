package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Filter(
    @Expose @SerializedName("app_user_id") val appUserId: Any,
    @Expose @SerializedName("currency_id") val currencyId: Int,
    @Expose @SerializedName("point") val point: Point
)