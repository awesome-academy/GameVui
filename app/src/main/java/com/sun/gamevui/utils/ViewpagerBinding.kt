package com.sun.gamevui.utils

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.sun.gamevui.base.BindDataAdapter

@BindingAdapter("app:data_viewpager")
fun <T> setDataViewPager(viewPager: ViewPager, data: List<T>?) {
    if (viewPager.adapter is BindDataAdapter<*>) {
        (viewPager.adapter as BindDataAdapter<T>).setData(data)
    }
}
