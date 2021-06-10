package com.sun.gamevui.data.remote

import com.sun.gamevui.data.model.RssResponse
import retrofit2.http.GET

interface RssService {
    @GET(ApiConfig.BASE_ENDPOINT_RSS)
    suspend fun getNews(): RssResponse
}
