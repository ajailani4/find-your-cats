package com.ajailani.kmpexample.data.remote.data_source

import com.ajailani.kmpexample.data.remote.api_service.CatService

class CatRemoteDataSource(private val service: CatService) {
    suspend fun getCats() = service.getCats()

    suspend fun getCatDetail(name: String) = service.getCatDetail(name)
}