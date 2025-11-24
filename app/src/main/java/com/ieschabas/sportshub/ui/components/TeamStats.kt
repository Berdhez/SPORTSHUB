package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme


@Composable
fun TeamStats(
    points: Int,
    won: Int,
    drawn: Int,
    lost: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        StatChip(label = "Pts $points")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "G $won")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "E $drawn")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "P $lost")
    }
}

@Composable
fun StatChip(label: String) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8E8E8))
    ) {
        Text(
            text = label,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamStatsPreview() {
    SPORTSHUBTheme {
        TeamStats(points = 27, won = 8, drawn = 3, lost = 2)
    }
}
