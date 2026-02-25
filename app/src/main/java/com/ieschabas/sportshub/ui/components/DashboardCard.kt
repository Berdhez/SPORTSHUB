package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*

@Composable
fun DashboardCard(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    lottieUrl: String? = null,
    lottieSpeed: Float = 1f,
    lottieAlpha: Float = 1f,
    lottieOffsetY: androidx.compose.ui.unit.Dp = 0.dp,
    textColor: Color = Color.White,
    contentAlignment: Alignment = Alignment.Center,
    textPaddingBottom: androidx.compose.ui.unit.Dp = 0.dp
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .height(300.dp)
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = contentAlignment
    ) {
        // Animación Lottie de fondo (si se proporciona URL)
        if (lottieUrl != null) {
            val composition by rememberLottieComposition(
                LottieCompositionSpec.Url(lottieUrl)
            )
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                speed = lottieSpeed
            )
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = -lottieOffsetY)
                    .alpha(lottieAlpha)
            )
        }

        // Texto encima de la animación
        Text(
            text = text,
            color = textColor,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = textPaddingBottom)
        )
    }
}
