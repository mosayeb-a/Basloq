package com.ma.basloq.service

import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes

interface QuoteService {

   suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ) : Quotes

    suspend fun getQuoteOfTheDay() : Quote

    suspend fun getQuote(quoteId : String) : Quote
}