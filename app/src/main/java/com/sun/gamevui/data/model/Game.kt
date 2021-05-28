package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "game")
data class Game(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Long,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "image")
    @SerializedName("background_image")
    val image: String,
    @ColumnInfo(name = "score")
    @SerializedName("metacritic")
    val score: Long,
    @ColumnInfo(name = "platforms")
    @SerializedName("parent_platforms")
    val parentPlatforms: List<Platforms>
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Game, newItem: Game) =
                oldItem == newItem
        }
    }
}
