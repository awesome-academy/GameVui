package com.sun.gamevui.data.repository

import com.sun.gamevui.data.model.GenreResponse

interface GenreRepository {
    suspend fun getGenres(): GenreResponse
}
