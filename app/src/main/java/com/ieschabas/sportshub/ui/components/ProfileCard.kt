import androidx.compose.foundation.BorderStroke

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F2FA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nombre: Nombre Apellido", style = MaterialTheme.typography.bodyLarge)
            Text("Usuario: @nombreusuario", style = MaterialTheme.typography.bodyLarge)
            Text("Email: user@mail.com", style = MaterialTheme.typography.bodyLarge)
            Text("Miembro desde: 12/03/2024", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(8.dp))


            AssistChip(
                onClick = {  },
                label = { Text("Verificado", color = Color(0xFF00FF00), fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge) },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFF7F2FA)
                ),
                modifier = Modifier.widthIn(min = 90.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDangerZone(
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Zona de peligro",
            color = Color(0xFFB93830),
            style = MaterialTheme.typography.bodyLarge,

        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onLogoutClick,
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFB93830)),
            border = BorderStroke(width = 1.dp, color = Color.Black),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text("Cerrar sesión",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
                )
        }
    }
}
