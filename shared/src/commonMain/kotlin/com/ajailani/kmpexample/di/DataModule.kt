package com.ajailani.kmpexample.di

import com.ajailani.kmpexample.data.remote.api_service.CatService
import com.ajailani.kmpexample.data.remote.data_source.CatRemoteDataSource
import com.ajailani.kmpexample.data.repository.CatRepository
import org.koin.dsl.module

val dataModule = module {
    single { CatService(get()) }
    single { CatRemoteDataSource(get()) }
    single { CatRepository(get()) }
}