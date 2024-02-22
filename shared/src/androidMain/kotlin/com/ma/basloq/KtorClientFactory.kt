package com.ma.basloq

import com.ma.basloq.common.API_KEY
import com.ma.basloq.common.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual class KtorClientFactory {
    actual fun build(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url(BASE_URL)
                headers {
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                    header("Authorization", "Token token=$API_KEY")
                }
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}
