package com.ajailani.kmpexample.di

import org.koin.dsl.module

val appModule = module {
    includes(
        networkModule,
        dataModule
    )
}