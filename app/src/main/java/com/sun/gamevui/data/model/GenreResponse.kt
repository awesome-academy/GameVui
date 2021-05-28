package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("results")
    val results: List<Genre>
) {
}
