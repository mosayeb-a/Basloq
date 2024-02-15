package com.ma.basloq.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("followers")
    val followers: Int,
    @SerialName("following")
    val following: Int,
    @SerialName("login")
    val username: String,
    @SerialName("pic_url")
    val picUrl: String,
    @SerialName("pro")
    val pro: Boolean,
    @SerialName("public_favorites_count")
    val publicFavoritesCount: Int
)