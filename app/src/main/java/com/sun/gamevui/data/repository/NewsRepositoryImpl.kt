package com.sun.gamevui.data.repository

import com.sun.gamevui.data.NewsDataSource

class NewsRepositoryImpl(
    private val remote: NewsDataSource
) : NewsRepository {
    override suspend fun getNews() = remote.getNews()
}
