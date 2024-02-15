package com.ma.basloq.android.feature.list

import com.ma.basloq.common.BasloqException
import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.model.Quotes
import com.ma.basloq.data.repo.QuoteRepository
import kotlinx.coroutines.flow.Flow

data class QuoteListState(
    val quotes : List<Quote> = emptyList(),
    val isLoading : Boolean = false,
    val error : BasloqException? = null
)
