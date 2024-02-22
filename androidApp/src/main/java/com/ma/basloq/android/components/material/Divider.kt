package com.ma.basloq.android.components.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasloqDivider(
    modifier: Modifier,
) {
    Divider(
        modifier = modifier
            .fillMaxWidth(),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.outline
    )
}