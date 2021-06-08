package com.sun.gamevui.data

import com.sun.gamevui.data.local.GameDao
import com.sun.gamevui.data.model.Game

class GameLocalDataSource(
    private val gameDao: GameDao
) : GameDataSource.Local {
    override suspend fun getSavedGames() =
        gameDao.getSavedGames()

    override suspend fun insertGame(game: Game) =
        gameDao.insertGame(game)

    override suspend fun deleteGame(game: Game) =
        gameDao.deleteGame(game)

    override suspend fun isFavorite(id: Long) =
        gameDao.isFavorite(id)
}
