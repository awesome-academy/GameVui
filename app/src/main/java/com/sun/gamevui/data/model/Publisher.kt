package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Publisher(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Publisher>() {
            override fun areItemsTheSame(oldItem: Publisher, newItem: Publisher) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Publisher, newItem: Publisher) =
                oldItem == newItem
        }
    }
}
