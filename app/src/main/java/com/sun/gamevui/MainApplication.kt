package com.sun.gamevui

import android.app.Application
import com.sun.gamevui.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    networkModule,
                    apiModule,
                    viewModelModule,
                    repositoryModule,
                    roomModule
                )
            )
        }
    }
}
