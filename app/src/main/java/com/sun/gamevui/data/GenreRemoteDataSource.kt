package com.sun.gamevui.data

import com.sun.gamevui.data.remote.ApiService

class GenreRemoteDataSource(
    private val apiService: ApiService
) : GenreDataSource {
    override suspend fun getGenres() = apiService.getGenres()
}
