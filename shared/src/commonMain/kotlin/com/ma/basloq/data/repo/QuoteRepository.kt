package com.ma.basloq.data.repo

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes

interface QuoteRepository {

    suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ): Quotes

    suspend fun getQuoteOfTheDay(): Quote

    suspend fun getQuote(quoteId: String): Quote

    suspend fun getFavoriteProduct(): List<Quote>

    suspend fun addToFavorite(quote: Quote): Boolean

    suspend fun deleteFromFavorite(quote: Quote): Boolean
}