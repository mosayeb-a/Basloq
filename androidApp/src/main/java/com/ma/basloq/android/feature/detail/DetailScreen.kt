package com.ma.basloq.android.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(
    state: QuoteDetailState
) {
    Box {
        Text(
            text = state.quoteId.toString(),
            modifier = Modifier
                .align(Alignment.Center),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}