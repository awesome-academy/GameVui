package com.example.demomvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:loadImage")
fun ImageView.loadImage(uri: String) {
    Glide.with(context)
        .load(uri)
        .into(this)
}
