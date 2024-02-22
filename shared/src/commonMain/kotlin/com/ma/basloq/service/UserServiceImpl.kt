package com.ma.basloq.service

import com.ma.basloq.common.exceptionAwareRequest
import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod


class UserServiceImpl(
    private val httpClient: HttpClient
) : UserService {

    override suspend fun createUser(
        username: String,
        email: String,
        password: String
    ): UserTokenResponse {
        return httpClient.exceptionAwareRequest<UserTokenResponse>(url = "users") {
            method = HttpMethod.Post
            setBody(
                mapOf(
                    "user" to mapOf(
                        "login" to username,
                        "email" to email,
                        "password" to password
                    )
                )
            )
        }
    }

    override suspend fun login(username: String, password: String): SessionTokenResponse {
         return  httpClient.exceptionAwareRequest("session") {
            method = HttpMethod.Post
            setBody(
                mapOf(
                    "user" to mapOf(
                        "login" to username,
                        "password" to password
                    )
                )
            )
        }

    }

    override suspend fun logout(): String {
        return httpClient.exceptionAwareRequest("session") {
           method = HttpMethod.Post
        }
    }
}