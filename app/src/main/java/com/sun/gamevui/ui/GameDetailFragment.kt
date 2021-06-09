package com.sun.gamevui.ui

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.model.Developer
import com.sun.gamevui.data.model.Genre
import com.sun.gamevui.data.model.Publisher
import com.sun.gamevui.databinding.FragmentGameDetailBinding
import com.sun.gamevui.ui.adapter.*
import com.sun.gamevui.utils.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : BaseFragment<FragmentGameDetailBinding>() {

    private val imageSlideAdapter by lazy { context?.let { ImageSlideAdapter(it) } }
    private val genresAdapter = GenresAdapter(::onGenreClick)
    private val publisherAdapter = PublisherAdapter(::onPublisherClick)
    private val developerAdapter = DeveloperAdapter(::onDeveloperClick)
    private val ratingsAdapter = RatingsAdapter()
    private val arg: GameDetailFragmentArgs by navArgs()

    override val layoutId get() = R.layout.fragment_game_detail
    override val viewModel by viewModel<GameDetailViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        viewModel.apply {
            getGameDetail(arg.game.id)
            checkFavorite(arg.game.id)
        }
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            detailVM = viewModel
            recyclerRatings.adapter = ratingsAdapter
            recyclerGenre.adapter = genresAdapter
            recyclerDeveloper.adapter = developerAdapter
            recyclerPublisher.adapter = publisherAdapter
            viewPagerBanner.adapter = imageSlideAdapter
            tabIndicator.setupWithViewPager(viewPagerBanner, true)
        }
    }

    override fun initActions() {
        binding?.apply {
            textAdd.setOnClickListener {
                viewModel.insertGame(arg.game)
            }
            imageBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun onGenreClick(genre: Genre) {
        val action = GameDetailFragmentDirections.actionDetailFragmentToTagFragment(
            genre.id,
            Constant.BASE_GENRE
        )
        findNavController().navigate(action)
    }

    private fun onDeveloperClick(developer: Developer) {
        val action = GameDetailFragmentDirections.actionDetailFragmentToTagFragment(
            developer.id,
            Constant.BASE_DEVELOPER
        )
        findNavController().navigate(action)
    }

    private fun onPublisherClick(publisher: Publisher) {
        val action = GameDetailFragmentDirections.actionDetailFragmentToTagFragment(
            publisher.id,
            Constant.BASE_PUBLISHER
        )
        findNavController().navigate(action)
    }
}
