package com.ma.basloq.data.repo

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import com.ma.basloq.data.repo.source.QuoteDataSource

class QuoteRepositoryImpl(
    private val quoteLocalDataSource: QuoteDataSource,
    private val quoteRemoteDataSource: QuoteDataSource
) : QuoteRepository {

    override suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ): Quotes = quoteRemoteDataSource.getQuotes(
        query = query,
        type = type,
        private = private,
        hidden = hidden,
        page = page
    )

    override suspend fun getQuoteOfTheDay(): Quote =
        quoteRemoteDataSource.getQuoteOfTheDay()

    override suspend fun getQuote(quoteId: String): Quote =
        quoteRemoteDataSource.getQuote(quoteId)

    override suspend fun getFavoriteQuotes(): List<Quote> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorite(quote: Quote): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorite(quote: Quote): Boolean {
        TODO("Not yet implemented")
    }
}
