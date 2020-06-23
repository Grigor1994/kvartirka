package com.grigor.kvartirka.data.model.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Currency(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("label") val label: String
)