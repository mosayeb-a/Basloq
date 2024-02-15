package com.ma.basloq.service

import com.ma.basloq.common.exceptionAwareRequest
import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod

class QuoteServiceImpl(
    private val httpClient: HttpClient
) : QuoteService {

    override suspend fun getQuotes(
        query: String?,
        type: String?,
        private: Boolean?,
        hidden: Boolean?,
        page: Int?
    ): Quotes {
       return httpClient.exceptionAwareRequest<Quotes>("quotes") {
            method = HttpMethod.Get
            parameter("filter", query)
            parameter("type", type)
            parameter("private", private)
            parameter("hidden", hidden)
            parameter("page", page)
        }
    }

    override suspend fun getQuoteOfTheDay(): Quote {
        return httpClient.exceptionAwareRequest("qotd") {
            method = HttpMethod.Get
        }
    }


    override suspend fun getQuote(quoteId: String): Quote {
        return httpClient.exceptionAwareRequest("quotes/$quoteId") {
            method = HttpMethod.Get
        }
    }
}