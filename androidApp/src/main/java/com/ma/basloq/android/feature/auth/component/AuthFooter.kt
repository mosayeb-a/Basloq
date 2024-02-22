package com.ma.basloq.android.feature.auth.component

import BasloqButton
import BasloqTextButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.components.material.BasloqDivider
import com.ma.basloq.android.components.material.padding

@Composable
fun AuthFooter(
    authTextHint: String,
    authTextAction: String,
    onAuthActionClick: () -> Unit,
    onOtherAction: () -> Unit,
    otherTextAction: String
) {
    Column {
        BasloqButton(
            onClick = { onAuthActionClick() },
            modifier = Modifier
                .padding(top = MaterialTheme.padding.medium)
                .fillMaxWidth(),
            text = authTextAction
        )

        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "privacy policy",
            style = MaterialTheme.typography.labelSmall
        )
        BasloqDivider(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.padding.extraLarge,
                    end = MaterialTheme.padding.extraLarge,
                    top = MaterialTheme.padding.small,
                )
                .fillMaxWidth()
        )
        Text(
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally),
            text = authTextHint,
            style = MaterialTheme.typography.labelMedium
        )
        BasloqTextButton(
            onClick = { onOtherAction() },
            modifier = Modifier
                .padding(top = MaterialTheme.padding.small)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = otherTextAction,
        )
    }
}