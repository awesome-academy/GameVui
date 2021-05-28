package com.sun.gamevui.data.repository

import com.sun.gamevui.data.GenreDataSource

class GenreRepositoryImpl(
    private val remote: GenreDataSource
) : GenreRepository {
    override suspend fun getGenres() = remote.getGenres()
}
