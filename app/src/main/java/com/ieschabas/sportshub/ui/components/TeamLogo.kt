package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.ieschabas.sportshub.R


@Composable
fun TeamLogo(
    modifier: Modifier = Modifier,
    resId: Int = R.drawable.logo1
) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = "Team Logo",
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(CircleShape)
    )
}
