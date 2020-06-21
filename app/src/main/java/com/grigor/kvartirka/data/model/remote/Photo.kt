package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Photo(
    val url: String,
    val verified: Boolean
)