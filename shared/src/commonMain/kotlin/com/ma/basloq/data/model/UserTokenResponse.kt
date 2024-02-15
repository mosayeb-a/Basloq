package com.ma.basloq.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserTokenResponse(
    @SerialName("login")
    val username: String,
    @SerialName("User-Token")
    val userToken: String?
)

