package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class PhotoDefault(
    val height: Int,
    val url: String,
    val verified: Boolean,
    val width: Int
)