package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.RssItem
import com.sun.gamevui.databinding.FragmentNewsBinding
import com.sun.gamevui.ui.adapter.NewsAdapter
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
    }
}
