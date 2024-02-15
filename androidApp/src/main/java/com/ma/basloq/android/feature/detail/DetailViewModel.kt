package com.ma.basloq.android.feature.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//const val EXTRA_KEY_DATA = "data"

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state by mutableStateOf(QuoteDetailState())

    init {
        savedStateHandle.get<Int>("quoteId")?.let { quoteId ->
            state = state.copy(quoteId = quoteId)
        }
    }
}