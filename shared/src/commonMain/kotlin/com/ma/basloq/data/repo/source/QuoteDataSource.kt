package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.FilterBy
import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes

interface QuoteDataSource {

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