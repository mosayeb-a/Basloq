package com.ma.basloq.android.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.components.material.Surface
import com.ma.basloq.android.components.screens.EmptyScreen
import com.ma.basloq.common.BasloqException
import com.ma.basloq.data.model.FilterBy
import com.ma.basloq.data.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun QuoteListScreen(
    onQuoteClick: (Int) -> Unit,
    viewModel: QuoteListViewModel,
) {
    val state = viewModel.state

    if (state.error?.type == BasloqException.Type.EMPTY_SCREEN)
        EmptyScreen(
            message = state.error.userFriendlyMessage,
            modifier = Modifier.fillMaxSize(),
            actions = null,
        )
    else
    // todo

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (state.quotes.isEmpty())
                Text(text = "the list is empty", modifier = Modifier.padding(top = 49.dp))
            else
                LazyColumn {
                    items(state.quotes) { item: Quote ->
                        QuoteListItem(
                            modifier = Modifier
                                .fillMaxSize(),
                            quote = item,
                            onClick = {
                                onQuoteClick(item.id)
                                viewModel.addToFavorite(
                                    id = item.id,
                                    author = item.author,
                                    body = item.body,
                                    tags = item.tags,
                                    dialogue = item.dialogue
                                )
                            }
                        )
                    }
                }
        }
}


@Composable
fun QuoteListItem(
    quote: Quote,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(
            text = quote.body,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
