package com.sun.gamevui.di

import com.sun.gamevui.ui.GameDetailViewModel
import com.sun.gamevui.ui.HomeViewModel
import com.sun.gamevui.ui.SavedViewModel
import com.sun.gamevui.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { GameDetailViewModel(get(), get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { SavedViewModel(get()) }
}
