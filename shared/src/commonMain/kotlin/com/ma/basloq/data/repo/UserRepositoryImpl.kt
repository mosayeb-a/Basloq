package com.ma.basloq.data.repo


import com.ma.basloq.data.model.SessionTokenResponse
import com.ma.basloq.data.model.UserTokenResponse
import com.ma.basloq.data.repo.source.UserDataSource

class UserRepositoryImpl(
    private val userLocalDataSource: UserDataSource,
    private val userRemoteDataSource: UserDataSource,
) : UserRepository {

    override suspend fun createUser(
        username: String,
        email: String,
        password: String
    ): UserTokenResponse {
        val result = userRemoteDataSource.createUser(
            username = username,
            email = email,
            password = password
        )
        result.userToken?.let { token ->
            userLocalDataSource.saveUserToken(token = token)
            userLocalDataSource.saveUsername(username = username)
            userLocalDataSource.saveUserPassword(password = password)
        }
        createSession()
        return result
    }

    override suspend fun createSession(username: String, password: String): SessionTokenResponse {
        val result = userRemoteDataSource.createSession(username, password)
        result.sessionToken?.let { token ->
            userLocalDataSource.saveSessionToken(token)
        }
        return result
    }

    override suspend fun createSession(): SessionTokenResponse {
        val result =
            userRemoteDataSource.createSession(
                username = getUsername(),
                password = getUserPassword()
            )
        result.sessionToken?.let { token ->
            userLocalDataSource.saveSessionToken(token)
        }
        return result
    }

    override suspend fun destroySession(): String =
        userRemoteDataSource.destroySession()

    override fun loadUserToken(): String? {
        return userLocalDataSource.loadUserToken()
    }

    override fun loadSessionToken(): String? {
        return userLocalDataSource.loadSessionToken()
    }

    override fun getUsername(): String =
        userLocalDataSource.getUsername()

    override fun getUserPassword(): String =
        userLocalDataSource.getUserPassword()
}
