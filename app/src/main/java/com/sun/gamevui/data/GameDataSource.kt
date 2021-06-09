package com.sun.gamevui.data

import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.model.GameDetail
import com.sun.gamevui.data.model.GameResponse

interface GameDataSource {

    interface Remote {
        suspend fun getPopularGames(platform: String): GameResponse
        suspend fun getGameByGenre(genre: String, platform: String): GameResponse
        suspend fun getGameByName(name: String): GameResponse
        suspend fun getGameDetail(id: Long): GameDetail
        suspend fun getTagGenre(genreId: Long): GameResponse
        suspend fun getTagPublisher(publisherId: Long): GameResponse
        suspend fun getTagDeveloper(developerId: Long): GameResponse
    }

    interface Local {
        suspend fun getSavedGames(): List<Game>
        suspend fun insertGame(game: Game)
        suspend fun deleteGame(game: Game)
        suspend fun isFavorite(id: Long): Game
    }
}
