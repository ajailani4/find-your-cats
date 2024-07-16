package com.ajailani.kmpexample

import android.app.Application
import com.ajailani.kmpexample.di.appModule
import com.ajailani.kmpexample.di.viewModelModule
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