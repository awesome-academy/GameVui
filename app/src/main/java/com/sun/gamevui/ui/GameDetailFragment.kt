package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentGameDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : BaseFragment<FragmentGameDetailBinding>() {
    override val layoutId get() = R.layout.fragment_game_detail
    override val viewModel by viewModel<GameDetailViewModel>()

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
    }

}
