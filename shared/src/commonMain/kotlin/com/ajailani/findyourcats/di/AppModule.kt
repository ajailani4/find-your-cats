package com.ajailani.findyourcats.di

import org.koin.dsl.module

val appModule = module {
    includes(
        dataModule,
        networkModule
    )
}