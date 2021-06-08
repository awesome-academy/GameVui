package com.sun.gamevui.data

import com.sun.gamevui.data.model.ScreenshotResponse

interface ScreenshotDataSource {
    suspend fun getScreenshots(id: Long): ScreenshotResponse
}
