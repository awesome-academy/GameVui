package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentNewsDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    override val layoutId get() = R.layout.fragment_news_detail
    override val viewModel by viewModel<NewsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
