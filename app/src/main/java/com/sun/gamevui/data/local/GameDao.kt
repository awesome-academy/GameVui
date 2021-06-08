package com.sun.gamevui.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.sun.gamevui.data.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    suspend fun getSavedGames(): List<Game>

    @Insert(onConflict = IGNORE)
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("SELECT * FROM game WHERE id =:id")
    fun isFavorite(id: Long): Game
}
