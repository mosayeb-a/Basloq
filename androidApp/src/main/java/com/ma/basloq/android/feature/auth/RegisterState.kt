package com.ma.basloq.android.feature.auth

import com.ma.basloq.common.BasloqException
import java.util.regex.Pattern

data class RegisterState(
    val email: String = "sdfadf@gmial.com",
    val password: String = "asdfdsfa",
    val username: String = "asdfadsf",
    val token: String = "",
    val error: BasloqException? = null,
    val isLoading: Boolean = false,
    val isUsernameInputError: Boolean = false,
    val isPasswordInputError: Boolean = false,
    val isEmailInputError: Boolean = false
) {
    private val emailRegex = Pattern.compile(
        "[a-zA-Z0-9+._%\\-+]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isEmailFormatCorrect(): Boolean {
//        Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return emailRegex.matcher(email).matches()
    }
}