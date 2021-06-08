package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.Developer
import com.sun.gamevui.databinding.ItemTagDeveloperBinding

class DeveloperAdapter(
    private val onItemClick: (Developer) -> Unit
) : BaseAdapter<Developer, DeveloperAdapter.DeveloperViewHolder>(Developer.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeveloperViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tag_developer,
                parent,
                false
            ), onItemClick
        )

    class DeveloperViewHolder(
        private val itemTagDeveloperBinding: ItemTagDeveloperBinding,
        onClickItem: (Developer) -> Unit
    ) : BaseViewHolder<Developer>(itemTagDeveloperBinding, onClickItem) {

        override fun bindData(item: Developer) {
            super.bindData(item)
            itemTagDeveloperBinding.developer = item
        }
    }
}
