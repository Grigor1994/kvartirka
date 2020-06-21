package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Phone(
    val normalized: String,
    val phone: String
)