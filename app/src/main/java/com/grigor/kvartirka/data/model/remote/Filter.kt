package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("app_user_id")
    val appUserId: Any,
    @SerializedName("currency_id")
    val currencyId: Int,
    val point: Point
)