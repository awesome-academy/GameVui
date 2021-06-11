package com.sun.gamevui.ui

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.RssItem
import com.sun.gamevui.databinding.FragmentNewsBinding
import com.sun.gamevui.ui.adapter.NewsAdapter
import com.sun.gamevui.utils.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsBinding>() {
    private val newsAdapter = NewsAdapter(::onItemClick)
    override val layoutId: Int get() = R.layout.fragment_news
    override val viewModel by viewModel<NewsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            newsVM = viewModel
            recyclerNews.adapter = newsAdapter
        }
    }

    override fun initActions() {
    }

    private fun onItemClick(rssItem: RssItem) {
        if (rssItem.link != null) {
            val link: String? = rssItem.link
            val action = link?.let {
                NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(it)
            }
            action?.let { findNavController().navigate(it) }
        } else Toast.makeText(activity, Constant.ERROR_LINK, Toast.LENGTH_SHORT).show()
    }
}
