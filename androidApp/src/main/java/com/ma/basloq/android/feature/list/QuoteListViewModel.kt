package com.ma.basloq.android.feature.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ma.basloq.common.BasloqException
import com.ma.basloq.data.model.Quote
import com.ma.basloq.data.repo.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteListViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    var state by mutableStateOf(QuoteListState())
        private set

    init {
        // this is just for test
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val quotes = quoteRepository.getQuotes(
                    query = null,
                    type = null,
                    private = null,
                    hidden = null,
                    page = 25
                )
                state = state.copy(
                    quotes = quotes.quotes,
                    isLoading = false
                )
            } catch (e: BasloqException) {
                state = state.copy(
                    error = e,
                    isLoading = false
                )
            }
        }
    }

}

