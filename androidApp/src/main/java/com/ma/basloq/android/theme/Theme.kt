package com.ma.basloq.android.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


val BasloqLightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = Black,
    onSecondary = White,
    outlineVariant = DarkGray,
    outline = Gray,
)

@Composable
fun BasloqTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = BasloqLightColorScheme,
        typography = BasloqTypography,
        shapes = BasloqShapes,
        content = content
    )
}
