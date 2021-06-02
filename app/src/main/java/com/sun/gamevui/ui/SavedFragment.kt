package com.sun.gamevui.ui

import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.FragmentSavedBinding
import com.sun.gamevui.ui.adapter.SavedGamesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedFragment : BaseFragment<FragmentSavedBinding>() {

    private val savedGamesAdapter = SavedGamesAdapter(::onItemClick)
    override val layoutId get() = R.layout.fragment_saved
    override val viewModel by viewModel<SavedViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            savedVM = viewModel
            recyclerSaved.adapter = savedGamesAdapter
        }
    }

    override fun initActions() {
    }

    private fun onItemClick(game: Game) {
    }
}
