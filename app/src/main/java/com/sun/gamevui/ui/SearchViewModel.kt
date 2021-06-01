package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repo: GameRepository
) : BaseViewModel() {
    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>>
        get() = _games

    fun getGameByName(name: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = repo.getGameByName(name)
            _games.postValue(gamesFromApi.results)
        }
    }
}
