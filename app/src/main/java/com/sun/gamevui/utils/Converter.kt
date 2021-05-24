package com.sun.gamevui.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sun.gamevui.data.model.Platform

class Converter {
    @TypeConverter
    fun toJsonPlatforms(platforms: List<Platform>): String {
        return Gson().toJson(platforms)
    }

    @TypeConverter
    fun fromJsonPlatforms(json: String): List<Platform> {
        val type = object : TypeToken<List<Platform>>() {}.type
        return Gson().fromJson(json, type)
    }
}
