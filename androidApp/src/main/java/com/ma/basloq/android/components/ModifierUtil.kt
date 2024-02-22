package com.ma.basloq.android.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

fun Modifier.basloqRippleColor(color: Color): Modifier = composed {
    indication(
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(
            bounded = false,
            color = color,
            radius = 16.dp
        )
    )
}

