package com.sun.gamevui.data.repository

import com.sun.gamevui.data.model.ScreenshotResponse

interface ScreenshotRepository {
    suspend fun getScreenshots(id: Long): ScreenshotResponse
}
