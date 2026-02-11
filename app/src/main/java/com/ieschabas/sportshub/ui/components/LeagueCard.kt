package com.ieschabas.sportshub.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LeagueCard(
    leagueName: String,
    city: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF3AA57A))
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(
            text = leagueName,
            color = Color.Black,
            fontSize = 20.sp,

        )
        Text(
            text = "Ciudad: $city",
            color = Color.Black.copy(alpha = 0.8f),
            fontSize = 14.sp
        )
    }
}
