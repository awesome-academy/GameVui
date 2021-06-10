package com.sun.gamevui.data

import com.sun.gamevui.data.remote.RssService

class NewsRemoteDataSource(
    private val rssService: RssService
) : NewsDataSource {
    override suspend fun getNews() = rssService.getNews()
}
