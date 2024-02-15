package com.ma.basloq.data.repo.source

import com.ma.basloq.service.UserService
import com.ma.basloq.common.BasloqException
import com.ma.basloq.common.Result
import com.ma.basloq.common.basloqExceptionMapper
import com.ma.basloq.common.handleRequestException
import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse


class UserRemoteDataSource(
    private val userService: UserService
) : UserDataSource {

    override suspend fun createUser(
        username: String,
        email: String,
        password: String
    ): UserTokenResponse =
        userService.createUser(username = username, email = email, password = password)

    override suspend fun createSession(username: String, password: String): SessionTokenResponse =
        userService.login(username = username, password = password)

    override suspend fun destroySession(): String =
        userService.logout()

    override fun loadSessionToken() {
        TODO("Not yet implemented")
    }

    override fun saveSessionToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun loadUserToken() {
        TODO("Not yet implemented")
    }

    override fun saveUserToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun saveUsername(username: String) {
        TODO("Not yet implemented")
    }

    override fun getUsername() : String {
        TODO("Not yet implemented")
    }

    override fun saveUserPassword(password: String) {
        TODO("Not yet implemented")
    }

    override fun getUserPassword() : String {
        TODO("Not yet implemented")
    }
}