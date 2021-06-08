package com.sun.gamevui.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseAdapter
import com.sun.gamevui.base.BaseViewHolder
import com.sun.gamevui.data.model.Genre
import com.sun.gamevui.databinding.ItemTagGenreBinding

class GenresAdapter(
    private val onItemClick: (Genre) -> Unit
) : BaseAdapter<Genre, GenresAdapter.GenreViewHolder>(Genre.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GenreViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tag_genre,
                parent,
                false
            ), onItemClick
        )

    class GenreViewHolder(
        private val itemTagGenreBinding: ItemTagGenreBinding,
        onClickItem: (Genre) -> Unit
    ) : BaseViewHolder<Genre>(itemTagGenreBinding, onClickItem) {

        override fun bindData(item: Genre) {
            super.bindData(item)
            itemTagGenreBinding.genre = item
        }
    }
}
