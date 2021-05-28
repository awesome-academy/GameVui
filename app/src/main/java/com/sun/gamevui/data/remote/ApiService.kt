package com.sun.gamevui.data.remote

import com.sun.gamevui.data.model.GameResponse
import com.sun.gamevui.data.model.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConfig.BASE_GAME)
    suspend fun getPopularGames(
        @Query(ApiConfig.BASE_PARENT_PLATFORM) platform: String
    ): GameResponse

    @GET(ApiConfig.BASE_GENRE)
    suspend fun getGenres(): GenreResponse
}
