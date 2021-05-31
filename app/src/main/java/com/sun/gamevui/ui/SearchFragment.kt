package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutId get() = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
