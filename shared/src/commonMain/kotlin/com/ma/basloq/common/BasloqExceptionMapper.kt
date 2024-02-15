package com.ma.basloq.common

import com.ma.basloq.data.model.ErrorResponse
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException

fun basloqExceptionMapper(
    errorCode: Int?,
    exception: Exception?
): BasloqException {
    if (errorCode != null) {
        when (errorCode) {
            31 -> {
                return BasloqException(
                    type = BasloqException.Type.SIMPLE,
                    userFriendlyMessage = "User session present",
                )
            }

            32 -> {
                // or user exist
                return BasloqException(
                    type = BasloqException.Type.SIMPLE,
                    userFriendlyMessage = "Email is not a valid email; Password is too short (minimum is 5 characters)",
                )
            }
        }
    } else if (exception != null) {
        when (exception) {
            is IOException -> {
                return BasloqException(
                    type = BasloqException.Type.SIMPLE,
                    userFriendlyMessage = "unavailable service",
                )
            }
        }
    } else {
        return BasloqException(
            type = BasloqException.Type.EMPTY_SCREEN,
            userFriendlyMessage = "Unknown Error in the last else ",
        )
    }
    return BasloqException(
        type = BasloqException.Type.EMPTY_SCREEN,
        userFriendlyMessage = "Unknown Error",
    )
}

fun handleRequestException(exception: Exception): BasloqException {
    throw basloqExceptionMapper(exception = exception, errorCode = null)
}

suspend fun handleResponseException(exception: Exception, httpResponse: HttpResponse): BasloqException {
    val errorCode = httpResponse.body<ErrorResponse>().errorCode
    throw basloqExceptionMapper(exception = exception, errorCode = errorCode)
}