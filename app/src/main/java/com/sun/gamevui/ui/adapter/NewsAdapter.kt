package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.RssItem
import com.sun.gamevui.databinding.ItemNewsBinding

class NewsAdapter(
    private val onItemClick: (RssItem) -> Unit
) : BaseAdapter<RssItem, NewsAdapter.NewsViewHolder>(RssItem.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_news,
                parent,
                false
            ), onItemClick
        )

    class NewsViewHolder(
        private val itemNewsBinding: ItemNewsBinding,
        onClickItem: (RssItem) -> Unit
    ) : BaseViewHolder<RssItem>(itemNewsBinding, onClickItem) {

        override fun bindData(item: RssItem) {
            super.bindData(item)
            itemNewsBinding.news = item
        }
    }
}
