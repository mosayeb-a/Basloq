package com.ma.basloq

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun build() : HttpClient
}
