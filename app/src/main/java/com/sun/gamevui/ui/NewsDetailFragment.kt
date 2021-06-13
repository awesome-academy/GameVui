package com.sun.gamevui.ui

import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.gamevui.R
import com.sun.gamevui.base.BaseFragment
import com.sun.gamevui.databinding.FragmentNewsDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    private val arg: NewsDetailFragmentArgs by navArgs()

    override val layoutId get() = R.layout.fragment_news_detail
    override val viewModel by viewModel<NewsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            webNews.apply {
                webViewClient = WebViewClient()
                settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                loadUrl(arg.link)
            }
        }
    }

    override fun initActions() {
        binding?.imageBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        onBackPressed()
        refreshWebView()
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding?.webNews?.canGoBack() == true) {
                    binding?.webNews?.goBack()
                } else {
                    findNavController().popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    private fun refreshWebView() {
        binding?.apply {
            refreshLayout.setOnRefreshListener {
                webNews.reload()
                refreshLayout.isRefreshing = false
            }
        }
    }
}
