package com.sun.gamevui.di

import com.sun.gamevui.data.GameDataSource
import com.sun.gamevui.data.GameRemoteDataSource
import com.sun.gamevui.data.GenreDataSource
import com.sun.gamevui.data.GenreRemoteDataSource
import com.sun.gamevui.data.repository.GameRepository
import com.sun.gamevui.data.repository.GameRepositoryImpl
import com.sun.gamevui.data.repository.GenreRepository
import com.sun.gamevui.data.repository.GenreRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GameDataSource.Remote> { GameRemoteDataSource(get()) }
    single<GameRepository> { GameRepositoryImpl(get()) }
    single<GenreDataSource> { GenreRemoteDataSource(get()) }
    single<GenreRepository> { GenreRepositoryImpl(get()) }
}
