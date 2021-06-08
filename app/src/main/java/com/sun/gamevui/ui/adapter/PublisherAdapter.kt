package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.Publisher
import com.sun.gamevui.databinding.ItemTagPublisherBinding

class PublisherAdapter(
    private val onItemClick: (Publisher) -> Unit
) : BaseAdapter<Publisher, PublisherAdapter.PublisherViewHolder>(Publisher.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PublisherViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tag_publisher,
                parent,
                false
            ), onItemClick
        )

    class PublisherViewHolder(
        private val itemTagPublisherBinding: ItemTagPublisherBinding,
        onClickItem: (Publisher) -> Unit
    ) : BaseViewHolder<Publisher>(itemTagPublisherBinding, onClickItem) {

        override fun bindData(item: Publisher) {
            super.bindData(item)
            itemTagPublisherBinding.publisher = item
        }
    }
}
