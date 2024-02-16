package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import kotlinx.coroutines.flow.Flow

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

    suspend fun getFavoriteQuotes(): Flow<List<Quote>>

    suspend fun addToFavorite(quote: Quote)

    suspend fun deleteFromFavorite(quoteId: Int)
}