package com.sun.gamevui.data

import com.sun.gamevui.data.model.GenreResponse

interface GenreDataSource {
    suspend fun getGenres(): GenreResponse
}
