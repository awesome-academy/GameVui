package com.sun.gamevui.data.repository

import com.sun.gamevui.data.model.RssResponse

interface NewsRepository {
    suspend fun getNews(): RssResponse
}
