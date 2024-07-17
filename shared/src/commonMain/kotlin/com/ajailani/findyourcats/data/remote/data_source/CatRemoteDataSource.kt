package com.ajailani.findyourcats.data.remote.data_source

import com.ajailani.findyourcats.data.remote.api_service.CatService

class CatRemoteDataSource(private val service: CatService) {
    suspend fun getCats() = service.getCats()

    suspend fun getCatDetail(id: String) = service.getCatDetail(id)
}