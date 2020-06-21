package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Meta(
    val limit: Int,
    val nearest: Int,
    val offset: Int
)