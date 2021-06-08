package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.GameDetail
import com.sun.gamevui.data.model.Screenshot
import com.sun.gamevui.data.repository.GameRepository
import com.sun.gamevui.data.repository.ScreenshotRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val gameRepo: GameRepository,
    private val screenshotRepo: ScreenshotRepository
) : BaseViewModel() {
    private val _detail = MutableLiveData<GameDetail>()
    val detail: LiveData<GameDetail>
        get() = _detail
    private val _screenshots = MutableLiveData<List<Screenshot>>()
    val screenshot: LiveData<List<Screenshot>>
        get() = _screenshots

    fun getGameDetail(id: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val detailFromApi = gameRepo.getGameDetail(id)
            getScreenshots(id)
            _detail.postValue(detailFromApi)
        }
    }

    fun getScreenshots(id: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val screenshotFromApi = screenshotRepo.getScreenshots(id)
            _screenshots.postValue(screenshotFromApi.results)
        }
    }
}
