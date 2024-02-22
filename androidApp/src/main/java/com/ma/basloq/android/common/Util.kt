package com.ma.basloq.android.common

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.ma.basloq.android.components.material.SecondaryItemAlpha
import java.util.regex.Pattern


fun Modifier.secondaryItemAlpha(): Modifier = this.alpha(SecondaryItemAlpha)


private val usernameRegex = Pattern.compile("^[a-zA-Z0-9_]{1,20}$")

fun isUsernameFormatCorrect(username: String): Boolean {
    return usernameRegex.matcher(username).matches()
}

private val passwordRegex = Pattern.compile("^.{5,120}$")

fun isPasswordFormatCorrect(password: String): Boolean {
    return passwordRegex.matcher(password).matches()
}
