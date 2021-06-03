package com.sun.gamevui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    binding: ViewDataBinding,
    onItemClick: (T) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    protected var item: T? = null

    init {
        binding.root.setOnClickListener {
            item?.let(onItemClick)
        }
    }

    open fun bindData(item: T) {
        this.item = item
    }
}
