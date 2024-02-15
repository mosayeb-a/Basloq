package com.ma.basloq.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//data class Quote(
//    @SerialName("author")
//    val author: String,
//    @SerialName("author_permalink")
//    val authorPermalink: String,
//    @SerialName("body")
//    val body: String,
//    @SerialName("dialogue")
//    val dialogue: Boolean?,
//    @SerialName("downvotes_count")
//    val downVotesCount: Int,
//    @SerialName("favorite")
//    val favorite: Boolean,
//    @SerialName("favorites_count")
//    val favoritesCount: Int,
//    @SerialName("id")
//    val id: Int,
//    @SerialName("tags")
//    val tags: List<String>,
//    @SerialName("upvotes_count")
//    val upVotesCount: Int?,
//    @SerialName("url")
//    val url: String?,
//    @SerialName("private")
//    val private: Boolean?,
//    @SerialName("source")
//    val source: String?,
//)
@Serializable
data class Quote(
    @SerialName("author")
    val author: String,
    @SerialName("author_permalink")
    val authorPermalink: String,
    @SerialName("body")
    val body: String,
    @SerialName("dialogue")
    val dialogue: Boolean,
    @SerialName("downvotes_count")
    val downvotesCount: Int,
    @SerialName("favorites_count")
    val favoritesCount: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("private")
    val `private`: Boolean,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("upvotes_count")
    val upvotesCount: Int,
    @SerialName("url")
    val url: String
)