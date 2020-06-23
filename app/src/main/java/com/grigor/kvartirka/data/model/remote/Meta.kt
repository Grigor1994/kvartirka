package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meta(
    @Expose @SerializedName("limit") val limit: Int,
    @Expose @SerializedName("nearest") val nearest: Int,
    @Expose @SerializedName("offset") val offset: Int
)