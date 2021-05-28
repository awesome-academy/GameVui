package com.sun.gamevui.utils

import android.widget.Spinner
import androidx.databinding.BindingAdapter
import com.sun.gamevui.base.BindDataAdapter

@BindingAdapter("app:data_spinner")
fun <T> setDataSpinner(spinner: Spinner, data: List<T>?) {
    if (spinner.adapter is BindDataAdapter<*>) {
        (spinner.adapter as BindDataAdapter<T>).setData(data)
    }
}
