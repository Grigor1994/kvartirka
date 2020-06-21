package com.grigor.kvartirka

import android.app.Application
import com.grigor.kvartirka.di.appModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        // Koin
        startKoin {

        }
    }
    private fun getKoinModules(): List<Module> {
        return listOf(appModule)
    }
}