package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer


data class Player(val number: Int, val name: String, val position: String)

@Composable
fun PlayerList(players: List<Player>, onPlayerClick: (Player) -> Unit) {
    Column {
        players.forEach { player ->
            PlayerRow(player = player, onClick = { onPlayerClick(player) })
        }
    }
}

@Composable
fun PlayerRow(player: Player, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F2FA))

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.SportsSoccer,
                contentDescription = "Soccer ball icon",
                tint = Color(0xFF2E0854),
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFE6DFF1), shape = CircleShape)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "${player.number}. ${player.name}")
                Text(text = player.position, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerListPreview() {
    val players = listOf(
        Player(1, "Marcos Pérez", "Portero"),
        Player(2, "Otro Jugador", "Defensa")
    )
    SPORTSHUBTheme {
        PlayerList(players = players, onPlayerClick = {})
    }
}
