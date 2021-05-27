package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.ItemPopularBinding

class PopularAdapter(
    private val onClickItem: (Game) -> Unit
) : BaseAdapter<Game, PopularAdapter.PopularViewHolder>(Game.diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PopularViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_popular,
                parent,
                false
            ), onClickItem
        )

    class PopularViewHolder(
        private val itemPopularBinding: ItemPopularBinding,
        onClickItem: (Game) -> Unit
    ) : BaseViewHolder<Game>(itemPopularBinding, onClickItem) {
        override fun bindData(item: Game) {
            super.bindData(item)
            itemPopularBinding.game = item
        }
    }
}
