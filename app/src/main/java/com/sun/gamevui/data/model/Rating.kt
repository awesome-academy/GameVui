package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("count")
    val count: Long
)
