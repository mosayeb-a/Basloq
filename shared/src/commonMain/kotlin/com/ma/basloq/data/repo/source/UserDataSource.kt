package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse

interface UserDataSource {

    suspend fun createUser(
        username: String,
        email: String,
        password: String
    ): UserTokenResponse

    fun saveUserToken(token: String)
    fun loadUserToken() : String?
    fun saveUsername(username: String)
    fun getUsername() : String
    fun saveUserPassword(password: String)
    fun getUserPassword() : String

    suspend fun createSession(username: String, password: String): SessionTokenResponse
    suspend fun destroySession(): String

    fun loadSessionToken() : String?
    fun saveSessionToken(token: String)
}