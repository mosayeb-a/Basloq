package com.ma.basloq.data.repo.source

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes

class QuoteLocalDataSource : QuoteDataSource  {

    override suspend fun getFavoriteQuotes(): List<Quote> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorite(quote: Quote): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorite(quote: Quote): Boolean {
        TODO("Not yet implemented")
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
