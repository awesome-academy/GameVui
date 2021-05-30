package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.Game
import com.sun.gamevui.data.model.Genre
import com.sun.gamevui.data.remote.ApiConfig
import com.sun.gamevui.data.repository.GameRepository
import com.sun.gamevui.data.repository.GenreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val gameRepo: GameRepository,
    private val genreRepo: GenreRepository
) : BaseViewModel() {
    private val _popularGames = MutableLiveData<List<Game>>()
    val popularGames: LiveData<List<Game>>
        get() = _popularGames
    private val _genres = MutableLiveData<List<Genre>>()
    val genres: LiveData<List<Genre>>
        get() = _genres
    private val _gamesByGenre = MutableLiveData<List<Game>>()
    val gamesByGenre: LiveData<List<Game>>
        get() = _gamesByGenre

    init {
        getPopularGames(ApiConfig.BASE_PC)
        getGenres()
    }

    fun getPopularGames(platform: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesFromApi = gameRepo.getPopularGames(platform)
            _popularGames.postValue(gamesFromApi.results)
        }
    }

    private fun getGenres() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val genresFromApi = genreRepo.getGenres()
            _genres.postValue(genresFromApi.results)
        }
    }

    fun getGamesByGenre(genre: String, platform: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val gamesByGenreFromApi = gameRepo.getGamesByGenre(genre, platform)
            _gamesByGenre.postValue(gamesByGenreFromApi.results)
        }
    }
}
