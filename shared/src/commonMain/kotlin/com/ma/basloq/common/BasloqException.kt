package com.ma.basloq.common

class BasloqException(
    val type: Type,
    val userFriendlyMessage: String,
    val serverMessage: String? = null,
) : Throwable() {

    enum class Type {
        SIMPLE, EMPTY_SCREEN
    }
}

