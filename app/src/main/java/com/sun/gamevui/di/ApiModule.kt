package com.sun.gamevui.di

import com.sun.gamevui.data.remote.ApiService
import com.sun.gamevui.data.remote.RssService
import com.sun.gamevui.utils.Constant
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(named(Constant.API_SERVICE)) {
        get<Retrofit>(named(Constant.API_CLIENT))
            .create(ApiService::class.java)
    }
    single(named(Constant.RSS_SERVICE)) {
        get<Retrofit>(named(Constant.RSS_CLIENT))
            .create(RssService::class.java)
    }
}
