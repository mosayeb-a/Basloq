package com.ma.basloq.android.feature.auth

import com.ma.basloq.common.BasloqException

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val token: String = "",
    val error: BasloqException? = null,
    val isUsernameInputError: Boolean = false,
    val isPasswordInputError: Boolean = false,
)