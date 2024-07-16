package com.ajailani.kmpexample.data.remote.api_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class CatService(private val httpClient: HttpClient) {
    suspend fun getCats() = httpClient.get("cats")

    suspend fun getCatDetail(name: String) = httpClient.get("cats/$name")
}