package com.sun.gamevui.data.remote

import com.sun.gamevui.data.model.GameDetail
import com.sun.gamevui.data.model.GameResponse
import com.sun.gamevui.data.model.GenreResponse
import com.sun.gamevui.data.model.ScreenshotResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(ApiConfig.BASE_GAME)
    suspend fun getPopularGames(
        @Query(ApiConfig.BASE_PARENT_PLATFORM) platform: String
    ): GameResponse

    @GET(ApiConfig.BASE_GENRE)
    suspend fun getGenres(): GenreResponse

    @GET(ApiConfig.BASE_GAME)
    suspend fun getGamesByGenre(
        @Query(ApiConfig.BASE_GENRE) genre: String,
        @Query(ApiConfig.BASE_PARENT_PLATFORM) platform: String
    ): GameResponse

    @GET(ApiConfig.BASE_GAME)
    suspend fun getGameByName(
        @Query(ApiConfig.BASE_SEARCH) name: String
    ): GameResponse

    @GET("${ApiConfig.BASE_GAME}/{game_id}")
    suspend fun getGameDetail(
        @Path("game_id") id: Long
    ): GameDetail

    @GET("${ApiConfig.BASE_GAME}/{game_id}/screenshots")
    suspend fun getScreenshots(
        @Path("game_id") id: Long
    ): ScreenshotResponse

    @GET(ApiConfig.BASE_GAME)
    suspend fun getTagGenre(
        @Query(ApiConfig.BASE_GENRE) genreId: Long
    ): GameResponse

    @GET(ApiConfig.BASE_GAME)
    suspend fun getTagPublisher(
        @Query(ApiConfig.BASE_PUBLISHERS) publisherId: Long
    ): GameResponse

    @GET(ApiConfig.BASE_GAME)
    suspend fun getTagDeveloper(
        @Query(ApiConfig.BASE_DEVELOPER) developerId: Long
    ): GameResponse
}
