package com.ma.basloq.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionTokenResponse(
    @SerialName("email")
    val email: String,
    @SerialName("login")
    val login: String,
    @SerialName("User-Token")
    val sessionToken: String?
)