package com.sun.gamevui.data.model

import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("background_image")
    val image: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("ratings")
    val ratings: List<Rating>,
    @SerializedName("parent_platforms")
    val parentPlatform: List<Platforms>,
    @SerializedName("developers")
    val developers: List<Developer>,
    @SerializedName("genres")
    val genre: List<Genre>,
    @SerializedName("publishers")
    val publishers: List<Publisher>,
    @SerializedName("description_raw")
    val description: String
)
