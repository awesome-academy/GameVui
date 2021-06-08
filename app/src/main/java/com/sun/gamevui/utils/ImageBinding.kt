package com.example.demomvvm

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sun.gamevui.R
import com.sun.gamevui.data.model.Platforms

@BindingAdapter("app:loadImage")
fun ImageView.loadImage(uri: String?) {
    Glide.with(context)
        .load(uri)
        .error(R.drawable.image_error)
        .into(this)
}

@BindingAdapter(value = ["app:searchIcon", "app:platform"])
fun loadIcon(view: View, parentPlatform: List<Platforms>?, platform: String) {
    parentPlatform?.firstOrNull() {
        if (it.platform.name == platform) {
            view.visibility = View.VISIBLE
        }
        false
    }
}

