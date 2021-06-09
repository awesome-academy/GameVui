package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    override val layoutId: Int get() = R.layout.fragment_news
    override val viewModel by viewModel<NewsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
