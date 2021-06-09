package com.sun.gamevui.ui

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.FragmentTagBinding
import com.sun.gamevui.ui.adapter.GamesAdapter
import com.sun.gamevui.utils.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagFragment : BaseFragment<FragmentTagBinding>() {

    private val gamesAdapter = GamesAdapter(::onItemClick)
    private val arg: TagFragmentArgs by navArgs()

    override val layoutId get() = R.layout.fragment_tag
    override val viewModel by viewModel<TagViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            tagVM = viewModel
            recyclerGames.adapter = gamesAdapter
        }
        when (arg.type) {
            Constant.BASE_GENRE -> viewModel.getTagGenre(arg.tagId)
            Constant.BASE_PUBLISHER -> viewModel.getTagPublisher(arg.tagId)
            Constant.BASE_DEVELOPER -> viewModel.getTagDeveloper(arg.tagId)
        }
    }

    override fun initActions() {
        binding?.imageBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onItemClick(game: Game) {
        val action = TagFragmentDirections.actionTagFragmentToDetailFragment(game)
        findNavController().navigate(action)
    }
}
