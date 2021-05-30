package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
)
