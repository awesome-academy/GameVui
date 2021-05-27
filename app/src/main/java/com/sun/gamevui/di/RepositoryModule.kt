package com.sun.gamevui.di

import com.sun.gamevui.data.GameDataSource
import com.sun.gamevui.data.GameRemoteDataSource
import com.sun.gamevui.data.repository.GameRepository
import com.sun.gamevui.data.repository.GameRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GameDataSource.Remote> { GameRemoteDataSource(get()) }
    single<GameRepository> { GameRepositoryImpl(get()) }
}
