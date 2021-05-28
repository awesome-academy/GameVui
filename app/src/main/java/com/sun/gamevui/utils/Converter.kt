package com.sun.gamevui.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sun.gamevui.data.model.Platforms

class Converter {
    @TypeConverter
    fun toJsonPlatforms(parent_platforms: List<Platforms>): String {
        return Gson().toJson(parent_platforms)
    }

    @TypeConverter
    fun fromJsonPlatforms(json: String): List<Platforms> {
        val type = object : TypeToken<List<Platforms>>() {}.type
        return Gson().fromJson(json, type)
    }
}
