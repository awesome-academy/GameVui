package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.FragmentPlatformBinding
import com.sun.gamevui.ui.adapter.GenreAdapter
import com.sun.gamevui.ui.adapter.PopularAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class XboxFragment : BaseFragment<FragmentPlatformBinding>() {
    private val popularAdapter = PopularAdapter(this::clickItemPopular)
    private val genreAdapter by lazy { context?.let { GenreAdapter(it) } }
    override val layoutId = R.layout.fragment_platform
    override val viewModel by sharedViewModel<HomeViewModel>()

    override fun initViews() {
        binding?.apply {
            recyclerPopular.apply {
                setHasFixedSize(true)
                adapter = popularAdapter
            }
            spinnerGenre.adapter = genreAdapter
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
