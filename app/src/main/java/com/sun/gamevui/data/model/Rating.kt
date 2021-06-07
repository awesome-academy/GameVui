package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("count")
    val count: Long
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Rating>() {
            override fun areItemsTheSame(oldItem: Rating, newItem: Rating) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Rating, newItem: Rating) =
                oldItem == newItem
        }
    }
}
