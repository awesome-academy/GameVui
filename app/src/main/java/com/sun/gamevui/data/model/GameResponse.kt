package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("results")
    val results: List<Game>
)
