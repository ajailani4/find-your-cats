package com.ajailani.findyourcats.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual val ktorEngine: HttpClientEngine = Darwin.create()