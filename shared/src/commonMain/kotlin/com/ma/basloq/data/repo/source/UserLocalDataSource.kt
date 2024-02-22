package com.ma.basloq.data.repo.source

import com.ma.basloq.data.preferences.PlatformPreferences
import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse

class UserLocalDataSource(
    private val preferences: PlatformPreferences
) : UserDataSource {

    // todo save the username
    override fun saveUserToken(token: String) {
        preferences.put("user_token", token)
    }

    override fun loadUserToken(): String? {
        return preferences.getString("user_token")
    }

    override fun saveSessionToken(token: String) {
        preferences.put("session_token", token)
    }

    override fun loadSessionToken(): String? {
        return preferences.getString("session_token")
    }

    override fun saveUsername(username: String) {
        preferences.put("username", username)
    }

    override fun getUsername(): String {
        return preferences.getString("username")!!
    }

    override fun saveUserPassword(password: String) {
        preferences.put("password", password)
    }

    override fun getUserPassword(): String {
        return preferences.getString("password")!!
    }

    override suspend fun createSession(username: String, password: String): SessionTokenResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(
        username: String,
        email: String,
        password: String
    ): UserTokenResponse {
        TODO("Not yet implemented")
    }

    override suspend fun destroySession(): String {
        TODO("Not yet implemented")
    }


}
