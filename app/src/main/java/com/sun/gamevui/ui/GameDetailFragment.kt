package com.sun.gamevui.ui

import androidx.navigation.fragment.navArgs
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentGameDetailBinding
import com.sun.gamevui.ui.adapter.RatingsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : BaseFragment<FragmentGameDetailBinding>() {

    private val ratingsAdapter = RatingsAdapter()
    private val arg: GameDetailFragmentArgs by navArgs()

    override val layoutId get() = R.layout.fragment_game_detail
    override val viewModel by viewModel<GameDetailViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        viewModel.getGameDetail(arg.id)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            detailVM = viewModel
            recyclerRatings.adapter = ratingsAdapter
        }
    }

    override fun initActions() {
    }
}
