package com.sun.gamevui.data.repository

import com.sun.gamevui.data.ScreenshotDataSource

class ScreenshotRepositoryImpl(
    private val remote: ScreenshotDataSource
) : ScreenshotRepository {
    override suspend fun getScreenshots(id: Long) =
        remote.getScreenshots(id)
}
