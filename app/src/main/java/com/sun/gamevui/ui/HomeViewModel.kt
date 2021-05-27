package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.remote.ApiConfig
import com.sun.gamevui.data.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repo: GameRepository
) : BaseViewModel() {
    private val _popularGames = MutableLiveData<List<Game>>()
    val popularGames: LiveData<List<Game>>
        get() = _popularGames

    init {
        getPopularGames(ApiConfig.BASE_PC)
    }

    fun getPopularGames(platform: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = repo.getPopularGames(platform)
            _popularGames.postValue(gamesFromApi.results)
        }
    }
}
