package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Equipo(
    val nombre: String,
    val ciudad: String,
    val ies: String
)

@Composable
fun TeamsBox(equipo: Equipo) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(
                color = Color(0xFF64D1DD),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp)
    ) {
        Column {
            Text(text = equipo.nombre, style = MaterialTheme.typography.titleMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Ciudad: ${equipo.ciudad}", style = MaterialTheme.typography.bodySmall, color = Color.Black)
            Text(text = "IES: ${equipo.ies}", style = MaterialTheme.typography.bodySmall, color = Color.Black)
        }
    }
}
