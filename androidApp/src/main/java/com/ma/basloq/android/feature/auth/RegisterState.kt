package com.ma.basloq.android.feature.auth

import com.ma.basloq.common.BasloqException
import java.util.regex.Pattern

data class RegisterState(
    val email: String = "",
    val password: String = "",
    val username: String = "",
    val token : String = "",
    val error: BasloqException? = null,
    val isLoading: Boolean = false,
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
        if (emailRegex.matcher(email).matches())
            return true
        else
            throw BasloqException(
                type = BasloqException.Type.SIMPLE,
                userFriendlyMessage = "email isn't correct."
            )

    }

    private val usernameRegex = Pattern.compile("^[a-zA-Z0-9_]{1,20}$")

    fun isUsernameFormatCorrect(): Boolean {
        if (usernameRegex.matcher(username).matches())
            return true
        else
            throw BasloqException(
                type = BasloqException.Type.SIMPLE,
                userFriendlyMessage = "username isn't correct."
            )

    }

    private val passwordRegex = Pattern.compile("^.{5,120}$")

    fun isPasswordFormatCorrect(): Boolean {
        if (passwordRegex.matcher(password).matches())
            return true
        else
            throw BasloqException(
                type = BasloqException.Type.SIMPLE,
                userFriendlyMessage = "password isn't correct."
            )
    }
}