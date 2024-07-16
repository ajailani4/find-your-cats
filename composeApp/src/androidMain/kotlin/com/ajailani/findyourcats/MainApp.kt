package com.ajailani.findyourcats

import android.app.Application
import com.ajailani.findyourcats.di.appModule
import com.ajailani.findyourcats.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(appModule, viewModelModule)
        }
    }
}