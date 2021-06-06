package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class Screenshot(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image")
    val image: String
)
