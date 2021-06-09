package com.sun.gamevui.data.repository

import com.sun.gamevui.data.GameDataSource
import com.sun.gamevui.data.model.Game

class GameRepositoryImpl(
    private val remote: GameDataSource.Remote,
    private val local: GameDataSource.Local
) : GameRepository {
    override suspend fun getPopularGames(platform: String) =
        remote.getPopularGames(platform)

    override suspend fun getGamesByGenre(genre: String, platform: String) =
        remote.getGameByGenre(genre, platform)

    override suspend fun getGameByName(name: String) =
        remote.getGameByName(name)

    override suspend fun getSavedGames(): List<Game> =
        local.getSavedGames()

    override suspend fun insertGame(game: Game) =
        local.insertGame(game)


    override suspend fun deleteGame(game: Game) =
        local.deleteGame(game)

    override suspend fun getGameDetail(id: Long) =
        remote.getGameDetail(id)

    override suspend fun isFavorite(id: Long) =
        local.isFavorite(id)

    override suspend fun getTagGenre(genreId: Long) =
        remote.getTagGenre(genreId)

    override suspend fun getTagPublisher(publisherId: Long) =
        remote.getTagPublisher(publisherId)

    override suspend fun getTagDeveloper(developerId: Long) =
        remote.getTagDeveloper(developerId)
}
