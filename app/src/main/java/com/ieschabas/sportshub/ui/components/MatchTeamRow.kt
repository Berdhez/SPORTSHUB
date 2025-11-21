package com.ieschabas.sportshub.ui.components.matches

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieschabas.sportshub.ui.components.teams.TeamLogo

@Composable
fun MatchTeamRow(teamName: String, logoRes: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        TeamLogo(resId = logoRes, size = 30)

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = teamName,
            fontSize = 25.sp)
    }
}
