package com.ma.basloq.service

import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse


interface UserService {

    suspend fun createUser(
        username: String,
        email: String,
        password: String,
    ): UserTokenResponse

    // create a session
    suspend fun login(
        username: String,
        password: String
    ) : SessionTokenResponse

    // destroy the session
    suspend fun logout() : String
}