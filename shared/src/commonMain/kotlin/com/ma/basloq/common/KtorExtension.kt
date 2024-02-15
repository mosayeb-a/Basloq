package com.ma.basloq.common

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.serialization.JsonConvertException
import io.ktor.utils.io.errors.IOException

// todo clean exception handling with ktor client
suspend inline fun <reified T> HttpClient.exceptionAwareRequest(
    url: String,
    block: HttpRequestBuilder.() -> Unit,
): T {
    val response = try {
        request(urlString = url) {
            block()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        throw handleRequestException(exception = e)
    }

    return try {
        response.body<T>()
        // todo delete the JsonConvertException for every request and add manullay for some of request which returns an error response
    } catch (e: JsonConvertException) {
        e.printStackTrace()
        throw handleResponseException(exception = e, httpResponse = response)
    } catch (e: Exception) {
        e.printStackTrace()
        throw handleRequestException(exception = e)
    }
}
