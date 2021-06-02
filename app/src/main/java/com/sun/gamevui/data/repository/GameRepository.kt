package com.sun.gamevui.data.repository

import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.model.GameResponse

interface GameRepository {
    suspend fun getPopularGames(platform: String): GameResponse
    suspend fun getGamesByGenre(genre: String, platform: String): GameResponse
    suspend fun getGameByName(name: String): GameResponse
    suspend fun getSavedGames(): List<Game>
    suspend fun insertGame(game: Game)
    suspend fun deleteGame(game: Game)
}
