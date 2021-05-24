package com.sun.gamevui.di

import com.sun.gamevui.data.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(ApiService::class.java) }
}
