package com.sun.gamevui.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.sun.gamevui.R
import com.sun.gamevui.base.BindDataAdapter
import com.sun.gamevui.data.model.Genre
import com.sun.gamevui.databinding.ItemSpinnerBinding

class GenreAdapter(
    context: Context
) : ArrayAdapter<Genre>(context, 0), BindDataAdapter<Genre> {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ItemSpinnerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_spinner,
            parent,
            false
        )
        binding.genre = getItem(position)
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ItemSpinnerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_spinner,
            parent,
            false
        )
        binding.genre = getItem(position)
        return binding.root
    }

    override fun setData(data: List<Genre>?) {
        data?.let {
            clear()
            addAll(it.toMutableList())
        }
    }
}
