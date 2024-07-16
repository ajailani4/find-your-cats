package com.ajailani.findyourcats.di

import com.ajailani.findyourcats.data.remote.api_service.CatService
import com.ajailani.findyourcats.data.remote.data_source.CatRemoteDataSource
import com.ajailani.findyourcats.data.repository.CatRepository
import org.koin.dsl.module

val dataModule = module {
    single { CatService(get()) }
    single { CatRemoteDataSource(get()) }
    single { CatRepository(get()) }
}