package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.ui.screens.TeamStats




@Composable
fun ClassificationRow(stats: TeamStats, rank: Int) {

    val textColor = if (rank <= 4) Color.Magenta else Color.Black

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.weight(3f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = stats.logo),
                    contentDescription = "Logo de ${stats.teamName}",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stats.teamName,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            Row(
                modifier = Modifier.weight(2f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(stats.pj.toString(), color = textColor)
                Text(stats.g.toString(), color = textColor)
                Text(stats.e.toString(), color = textColor)
                Text(stats.p.toString(), color = textColor)
                Text(stats.pts.toString(), fontWeight = FontWeight.Bold, color = textColor)
            }
        }
        Divider()
    }
}
