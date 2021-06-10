package com.sun.gamevui.di

import com.sun.gamevui.data.*
import com.sun.gamevui.data.repository.*
import com.sun.gamevui.utils.Constant
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<GameDataSource.Remote> { GameRemoteDataSource(get(named(Constant.API_SERVICE))) }
    single<GameDataSource.Local> { GameLocalDataSource(get()) }
    single<GameRepository> { GameRepositoryImpl(get(), get()) }
    single<GenreDataSource> { GenreRemoteDataSource(get((named(Constant.API_SERVICE)))) }
    single<GenreRepository> { GenreRepositoryImpl(get()) }
    single<ScreenshotRepository> { ScreenshotRepositoryImpl(get()) }
    single<ScreenshotDataSource> { ScreenshotRemoteDataSource(get((named(Constant.API_SERVICE)))) }
    single<NewsDataSource> { NewsRemoteDataSource(get(named(Constant.RSS_SERVICE))) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}
