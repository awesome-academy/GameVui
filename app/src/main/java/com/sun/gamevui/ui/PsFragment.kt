package com.sun.gamevui.ui

import android.view.View
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.model.Genre
import com.sun.gamevui.data.remote.ApiConfig
import com.sun.gamevui.databinding.FragmentPlatformBinding
import com.sun.gamevui.ui.adapter.GamesAdapter
import com.sun.gamevui.ui.adapter.GenreAdapter
import com.sun.gamevui.ui.adapter.PopularAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class PsFragment : BaseFragment<FragmentPlatformBinding>() {

    private var genre: Genre? = null

    private val popularAdapter = PopularAdapter(this::clickItemPopular)
    private val gamesAdapter = GamesAdapter(this::clickItemGame)
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
            recyclerGames.adapter = gamesAdapter
        }
    }

    override fun initActions() {
        binding?.spinnerGenre?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    genre = parent?.getItemAtPosition(position) as Genre?
                    genre?.let {
                        viewModel.getGamesByGenre(
                            it.name.lowercase(Locale.getDefault()),
                            ApiConfig.BASE_PS
                        )
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }

    private fun clickItemPopular(game: Game) {
        val action = HomeFragmentDirections.actionHomeFragmentToGameDetailFragment(game)
        findNavController().navigate(action)
    }

    private fun clickItemGame(game: Game) {
        val action = HomeFragmentDirections.actionHomeFragmentToGameDetailFragment(game)
        findNavController().navigate(action)
    }
}
