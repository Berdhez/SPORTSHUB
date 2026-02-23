package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.domain.model.Match
import com.ieschabas.sportshub.R
@Composable
fun MatchCard(match: Match) {

    val homeLogo = getTeamLogo(match.homeTeamId)
    val awayLogo = getTeamLogo(match.awayTeamId)

    val score = if (match.homeScore != null && match.awayScore != null) {
        "${match.homeScore} - ${match.awayScore}"
    } else null

    Card(
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            MatchTimeRow(
                time = match.dateUtc,
                score = score
            )

            Spacer(modifier = Modifier.height(6.dp))

            MatchTeamRow(
                teamName = match.homeTeamId,
                logoRes = homeLogo
            )

            MatchTeamRow(
                teamName = match.awayTeamId,
                logoRes = awayLogo
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider(thickness = 2.dp)
        }
    }
}



fun getTeamLogo(teamId: String): Int {
    return when (teamId) {
        "team_rm",
        "team_ars" -> R.drawable.logo1

        "team_fcb",
        "team_mci" -> R.drawable.logo2

        else -> R.drawable.logo1
    }
}