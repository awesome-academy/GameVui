package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.ItemListSearchBinding

class SearchGamesAdapter(
    private val onItemClick: (Game) -> Unit
) : BaseAdapter<Game, SearchGamesAdapter.GameViewHolder>(Game.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GameViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list_search,
                parent,
                false
            ), onItemClick
        )

    class GameViewHolder(
        private val itemListSearchBinding: ItemListSearchBinding,
        onClickItem: (Game) -> Unit
    ) : BaseViewHolder<Game>(itemListSearchBinding, onClickItem) {

        override fun bindData(item: Game) {
            super.bindData(item)
            itemListSearchBinding.game = item
        }
    }
}
