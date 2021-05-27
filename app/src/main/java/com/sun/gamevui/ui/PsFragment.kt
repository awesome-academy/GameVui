package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.FragmentPlatformBinding
import com.sun.gamevui.ui.adapter.PopularAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PsFragment : BaseFragment<FragmentPlatformBinding>() {
    private val popularAdapter = PopularAdapter(this::clickItemPopular)
    override val layoutId = R.layout.fragment_platform
    override val viewModel by sharedViewModel<HomeViewModel>()

    override fun initViews() {
        binding?.recyclerPopular?.apply {
            setHasFixedSize(true)
            adapter = popularAdapter
        }
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
        }
    }

    override fun initActions() {
    }

    private fun clickItemPopular(game: Game) {
    }
}
