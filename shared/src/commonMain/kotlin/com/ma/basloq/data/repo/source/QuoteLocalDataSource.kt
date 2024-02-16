package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import com.ma.basloq.data.model.toDomainQuote
import com.ma.basloq.database.BasloqDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuoteLocalDataSource(
    db: BasloqDatabase
) : QuoteDataSource {

    private val queries = db.quotesQueries
    override suspend fun getFavoriteQuotes(): Flow<List<Quote>> {
        return queries
            .getQuotes()
            .asFlow()
            .mapToList()
            .map {
                it.map {
                    it.toDomainQuote()
                }
            }
    }

    override suspend fun addToFavorite(quote: Quote) {
        return queries
            .addQuote(
                _id = quote.id.toLong(),
                author = quote.author,
                body = quote.body,
                tags = quote.tags,
                dialog = quote.dialogue
            )
    }

    override suspend fun deleteFromFavorite(quoteId: Int) {
        return queries
            .deleteQuote(_id = quoteId.toLong())
    }

    override suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ): Quotes {
        TODO("Not yet implemented")
    }

    override suspend fun getQuoteOfTheDay(): Quote {
        TODO("Not yet implemented")
    }

    override suspend fun getQuote(quoteId: String): Quote {
        TODO("Not yet implemented")
    }
}