package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentTagBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagFragment : BaseFragment<FragmentTagBinding>() {

    override val layoutId get() = R.layout.fragment_tag
    override val viewModel by viewModel<TagViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }
}
