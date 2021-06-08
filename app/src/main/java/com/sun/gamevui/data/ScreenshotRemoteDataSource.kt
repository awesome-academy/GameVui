package com.sun.gamevui.data

import com.sun.gamevui.data.remote.ApiService

class ScreenshotRemoteDataSource(
    private val apiService: ApiService
) : ScreenshotDataSource {
    override suspend fun getScreenshots(id: Long) =
        apiService.getScreenshots(id)
}
