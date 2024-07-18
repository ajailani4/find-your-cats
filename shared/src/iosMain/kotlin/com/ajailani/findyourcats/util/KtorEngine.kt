package com.ajailani.findyourcats.util

import io.ktor.client.engine.darwin.Darwin

actual val ktorEngine = Darwin.create()