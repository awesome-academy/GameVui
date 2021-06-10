package com.sun.gamevui.data

import com.sun.gamevui.data.model.RssResponse

interface NewsDataSource {
    suspend fun getNews(): RssResponse
}
