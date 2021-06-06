package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Developer(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Developer>() {
            override fun areItemsTheSame(oldItem: Developer, newItem: Developer) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Developer, newItem: Developer) =
                oldItem == newItem
        }
    }
}

