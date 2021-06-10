package com.sun.gamevui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.gamevui.base.BaseViewModel
import com.sun.gamevui.data.model.RssItem
import com.sun.gamevui.data.repository.NewsRepository
import com.sun.gamevui.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepo: NewsRepository
) : BaseViewModel() {
    private val _news = MutableLiveData<List<RssItem>?>()
    val news: LiveData<List<RssItem>?>
        get() = _news

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val newFromRss = newsRepo.getNews()
            newFromRss.channel?.item?.forEach {
                it.image = it.image?.let { it -> getImage(it) }
            }
            _news.postValue(newFromRss.channel?.item)
        }
    }

    fun getImage(link: String): String {
        val src = link.substring(link.indexOf(Constant.BASE_INDEX))
        val image = src.split(Constant.BASE_SPLIT)
        return image[Constant.BASE_POSITION]
    }
}
