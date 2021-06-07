package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Genre>() {
            override fun areItemsTheSame(oldItem: Genre, newItem: Genre) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Genre, newItem: Genre) =
                oldItem == newItem
        }
    }
}
