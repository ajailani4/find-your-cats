package com.ajailani.findyourcats.util

import com.ajailani.findyourcats.data.repository.CatRepository
import com.ajailani.findyourcats.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class DIHelper : KoinComponent {
    fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }

    val catRepository by inject<CatRepository>()
}