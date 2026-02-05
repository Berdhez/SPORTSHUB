package com.ieschabas.sportshub.ui.components.matches

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.ui.components.Match

@Composable
fun MatchCard(match: Match) {
    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            MatchTimeRow(time = match.time, score = match.score)

            Spacer(modifier = Modifier.height(6.dp))

            MatchTeamRow(teamName = match.homeTeam, logoRes = match.homeLogoRes)
            MatchTeamRow(teamName = match.awayTeam, logoRes = match.awayLogoRes)

            Spacer(modifier = Modifier.height(8.dp))
            Divider(thickness = 2.dp)
        }
    }
}
