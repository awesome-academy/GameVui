package com.sun.gamevui.data

import com.sun.gamevui.data.remote.ApiService

class GameRemoteDataSource(
    private val apiService: ApiService
) : GameDataSource.Remote {
    override suspend fun getPopularGames(platform: String) =
        apiService.getPopularGames(platform)

    override suspend fun getGameByGenre(genre: String, platform: String) =
        apiService.getGamesByGenre(genre, platform)

    override suspend fun getGameByName(name: String) =
        apiService.getGameByName(name)

    override suspend fun getGameDetail(id: Long) =
        apiService.getGameDetail(id)

    override suspend fun getTagGenre(genreId: Long) =
        apiService.getTagGenre(genreId)

    override suspend fun getTagPublisher(publisherId: Long) =
        apiService.getTagPublisher(publisherId)

    override suspend fun getTagDeveloper(developerId: Long) =
        apiService.getTagDeveloper(developerId)
}
