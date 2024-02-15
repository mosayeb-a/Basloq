package com.ma.basloq.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quotes(
    @SerialName("last_page")
    val lastPage: Boolean,
    @SerialName("page")
    val page: Int,
    @SerialName("quotes")
    val quotes: List<Quote>,
)

enum class FilterBy(val value: String) {
    AUTHOR("author"),
    TAG("tag"),
    USER("user")
}


