package com.sun.gamevui.ui

import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.databinding.FragmentSearchBinding
import com.sun.gamevui.ui.adapter.SearchGamesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val searchGamesAdapter = SearchGamesAdapter(this::clickItemGame)
    override val layoutId get() = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            searchVM = viewModel
            recyclerSearch.adapter = searchGamesAdapter
        }
    }

    override fun initActions() {
        binding?.apply {
            editTextSearch.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    viewModel.getGameByName(editTextSearch.text.toString())
                }
                false
            }
        }
    }

    private fun clickItemGame(game: Game) {
        val action = SearchFragmentDirections.actionSearchFragmentToGameDetailFragment(game)
        findNavController().navigate(action)
    }
}
