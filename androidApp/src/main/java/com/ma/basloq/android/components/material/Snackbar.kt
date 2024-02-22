package com.ma.basloq.android.components.material

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.theme.Black


@Composable
fun BasloqSecondrySnackbar(hostState: SnackbarHostState) {
    SnackbarHost(
        hostState = hostState,
    ) {
        Snackbar(
            modifier = Modifier
                .padding(16.dp),
            containerColor = Black,
            actionContentColor = Color.White,
            dismissActionContentColor = Color.White,
        ) {
            Text(
                text = it.visuals.message,  // Display the message text
                color = Color.White,  // Set the text color
                style = MaterialTheme.typography.labelLarge
            )
//            if (snackbarData.actionLabel != null) {
//                TextButton(
//                    onClick = {},
//                    colors = ButtonDefaults.textButtonColors(contentColor = actionColor)
//                ) {
////                    Text(text = snackbarData.actionLabel!!)
//                }
        }
    }
}

