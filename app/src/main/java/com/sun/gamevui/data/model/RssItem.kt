package com.sun.gamevui.data.model

import androidx.recyclerview.widget.DiffUtil
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class RssItem(
    @field:Element(name = "title")
    var title: String? = null,
    @field:Element(name = "description")
    var image: String? = null,
    @field:Element(name = "link")
    var link: String? = null
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RssItem>() {
            override fun areItemsTheSame(oldItem: RssItem, newItem: RssItem) =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: RssItem, newItem: RssItem) =
                oldItem == newItem
        }
    }
}
