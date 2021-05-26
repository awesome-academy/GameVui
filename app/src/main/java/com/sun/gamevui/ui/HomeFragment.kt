package com.sun.gamevui.ui

import android.view.View
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(), View.OnClickListener {
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
        }
    }

    override fun initActions() {
    }

    override fun onClick(v: View?) {
    }

}
