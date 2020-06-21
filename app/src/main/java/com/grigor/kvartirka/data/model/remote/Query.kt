package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Query(
    val filter: Filter,
    val meta: Meta
)