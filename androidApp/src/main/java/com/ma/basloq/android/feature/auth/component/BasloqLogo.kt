package com.ma.basloq.android.feature.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.R

@Composable
fun BasloqLogo() {
    Image(
        modifier = Modifier
            .height(142.dp)
            .width(142.dp)
            .alpha(.9f)
            .rotate(180 % 360f),
        painter = painterResource(id = R.drawable.comma_fill_black),
        contentDescription = "logo",
        contentScale = ContentScale.Fit,
    )
}
