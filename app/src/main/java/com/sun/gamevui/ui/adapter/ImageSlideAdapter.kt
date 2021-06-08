package com.sun.gamevui.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.sun.gamevui.base.BindDataAdapter
import com.sun.gamevui.data.model.Screenshot
import com.sun.gamevui.databinding.ItemImageSlideBinding

class ImageSlideAdapter(
    val context: Context
) : PagerAdapter(), BindDataAdapter<Screenshot> {
    private var screenshots = mutableListOf<Screenshot>()
    override fun getCount() = screenshots.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemImageSlideBinding.inflate(LayoutInflater.from(context), container, false)
        binding.screenshot = screenshots[position]
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun setData(data: List<Screenshot>?) {
        if (data != null) {
            screenshots = data.toMutableList()
        }
        notifyDataSetChanged()
    }
}
