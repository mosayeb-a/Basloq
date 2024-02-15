package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import com.ma.basloq.service.QuoteService

class QuoteRemoteDataSource(
    private val quoteService: QuoteService
) : QuoteDataSource {

    override suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ): Quotes = quoteService.getQuotes(
        query = query,
        type = type,
        private = private,
        hidden = hidden,
        page = page
    )

    override suspend fun getQuoteOfTheDay(): Quote =
        quoteService.getQuoteOfTheDay()

    override suspend fun getQuote(quoteId: String): Quote =
        quoteService.getQuote(quoteId)

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
