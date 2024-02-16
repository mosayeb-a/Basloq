package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import com.ma.basloq.service.QuoteService
import kotlinx.coroutines.flow.Flow

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

    override suspend fun getFavoriteQuotes(): Flow<List<Quote>> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorite(quote: Quote) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorite(quoteId: Int) {
        TODO("Not yet implemented")
    }
}