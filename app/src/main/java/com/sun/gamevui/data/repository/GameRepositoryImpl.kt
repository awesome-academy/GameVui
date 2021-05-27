package com.sun.gamevui.data.repository

import com.sun.gamevui.data.GameDataSource

class GameRepositoryImpl(
    private val remote: GameDataSource.Remote
) : GameRepository {
    override suspend fun getPopularGames(platform: String) = remote.getPopularGames(platform)
}
