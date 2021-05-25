package com.sun.gamevui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sun.gamevui.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.sun.gamevui.data.local.AppDatabase.Companion.EXPORT_SCHEME
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.utils.Converter

@Database(
    entities = [Game::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "gameSaved"
        const val EXPORT_SCHEME = false
    }
}
