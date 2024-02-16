package com.ma.basloq.data.model

import com.ma.basloq.data.repo.source.Quotes

fun Quotes.toDomainQuote(): Quote {
    return Quote(
        author = author,
        id = _id.toInt(),
        body = body,
        tags = tags,
        dialogue = dialog,
        authorPermalink = null,
        downvotesCount = null,
        favoritesCount = null,
        private = null,
        upvotesCount = null,
        url = null,

        )
}