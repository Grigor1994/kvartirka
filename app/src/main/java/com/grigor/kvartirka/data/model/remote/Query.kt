package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Query(
    @Expose @SerializedName("filter") val filter: Filter,
    @Expose @SerializedName("meta") val meta: Meta
)