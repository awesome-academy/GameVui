package com.sun.gamevui.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sun.gamevui.base.BindDataAdapter

@BindingAdapter("app:data")
fun <T> setDataRecycler(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as BindDataAdapter<T>).setData(data)
}
