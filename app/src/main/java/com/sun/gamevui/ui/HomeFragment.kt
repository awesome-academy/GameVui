package com.sun.gamevui.ui

import com.google.android.material.tabs.TabLayout
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.data.remote.ApiConfig
import com.sun.gamevui.databinding.FragmentHomeBinding
import com.sun.gamevui.ui.adapter.HomeViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val pcFragment = PcFragment()
    private val psFragment = PsFragment()
    private val xboxFragment = XboxFragment()
    override val layoutId get() = R.layout.fragment_home
    override val viewModel by sharedViewModel<HomeViewModel>()

    override fun initViews() {
        HomeViewPagerAdapter(childFragmentManager).apply {
            addFragment(pcFragment, getString(R.string.title_pc))
            addFragment(psFragment, getString(R.string.title_ps))
            addFragment(xboxFragment, getString(R.string.title_xbox))
            binding?.viewPagerHome?.adapter = this
        }
        binding?.tabHome?.setupWithViewPager(binding?.viewPagerHome)
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
        }
    }

    override fun initActions() {
        tabHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> viewModel.getPopularGames(ApiConfig.BASE_PC)
                    1 -> viewModel.getPopularGames(ApiConfig.BASE_PS)
                    2 -> viewModel.getPopularGames(ApiConfig.BASE_XBOX)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
