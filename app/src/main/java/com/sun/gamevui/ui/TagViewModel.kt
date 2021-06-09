package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TagViewModel(
    private val gameRepo: GameRepository
) : BaseViewModel() {
    private val _games = MutableLiveData<List<Game>>()
    val games: LiveData<List<Game>>
        get() = _games

    fun getTagGenre(genreId: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = gameRepo.getTagGenre(genreId)
            _games.postValue(gamesFromApi.results)
        }
    }

    fun getTagDeveloper(developerId: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = gameRepo.getTagDeveloper(developerId)
            _games.postValue(gamesFromApi.results)
        }
    }

    fun getTagPublisher(publisherId: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = gameRepo.getTagPublisher(publisherId)
            _games.postValue(gamesFromApi.results)
        }
    }
}
