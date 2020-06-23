package com.grigor.kvartirka

import android.app.Application
import com.grigor.kvartirka.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Koin
        startKoin {
            androidContext(this@App)
            androidFileProperties()
            modules(appModule)
        }
    }
}