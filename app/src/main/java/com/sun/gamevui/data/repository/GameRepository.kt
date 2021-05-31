package com.sun.gamevui.data.repository

import com.sun.gamevui.data.model.GameResponse

interface GameRepository {
    suspend fun getPopularGames(platform: String): GameResponse
    suspend fun getGamesByGenre(genre: String, platform: String): GameResponse
    suspend fun getGameByName(name: String): GameResponse
}
