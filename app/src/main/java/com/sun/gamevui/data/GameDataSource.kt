package com.sun.gamevui.data

import com.sun.gamevui.data.model.GameResponse

interface GameDataSource {

    interface Remote {
        suspend fun getPopularGames(platform: String): GameResponse
        suspend fun getGameByGenre(genre: String, platform: String): GameResponse
    }
}
