package com.ma.basloq.android.feature.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ma.basloq.android.components.material.padding

@Composable
fun AuthHeader(
//    modifier: Modifier ,
    headlineText: String,
    subHeadlineText: String
) {
    Column(
        modifier = Modifier
            .padding(
                top = MaterialTheme.padding.extraLarge,
                start = MaterialTheme.padding.medium,
                end = MaterialTheme.padding.medium
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BasloqLogo()
        Text(
            text = headlineText,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subHeadlineText,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall
        )
    }
}