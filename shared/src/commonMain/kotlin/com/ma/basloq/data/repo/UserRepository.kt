package com.ma.basloq.data.repo

import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse

interface UserRepository {

    suspend fun createUser(username: String, email: String, password: String): UserTokenResponse

    suspend fun createSession(): SessionTokenResponse
    suspend fun destroySession(): String

    fun loadUserToken()
    fun loadSessionToken()

    fun getUsername() : String
    fun getUserPassword() : String
}