package com.sun.gamevui.di

import com.sun.gamevui.data.*
import com.sun.gamevui.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<GameDataSource.Remote> { GameRemoteDataSource(get()) }
    single<GameDataSource.Local> { GameLocalDataSource(get()) }
    single<GameRepository> { GameRepositoryImpl(get(), get()) }
    single<GenreDataSource> { GenreRemoteDataSource(get()) }
    single<GenreRepository> { GenreRepositoryImpl(get()) }
    single<ScreenshotRepository> { ScreenshotRepositoryImpl(get()) }
    single<ScreenshotDataSource> { ScreenshotRemoteDataSource(get()) }
}
