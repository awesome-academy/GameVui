package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.GameDetail
import com.sun.gamevui.data.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val gameRepo: GameRepository
) : BaseViewModel() {
    private val _detail = MutableLiveData<GameDetail>()
    val detail: LiveData<GameDetail>
        get() = _detail

    fun getGameDetail(id: Long) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val detailFromApi = gameRepo.getGameDetail(id)
            _detail.postValue(detailFromApi)
        }
    }
}
