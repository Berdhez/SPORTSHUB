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
import com.ieschabas.sportshub.domain.model.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCard(user: User) {
    Card(
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F2FA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nombre: ${user.fullName}", style = MaterialTheme.typography.bodyLarge)
            Text("Usuario: @${user.username}", style = MaterialTheme.typography.bodyLarge)
            Text("Email: ${user.email}", style = MaterialTheme.typography.bodyLarge)
            Text("Miembro desde: ${user.memberSince}", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(8.dp))

            if (user.verified) {
                AssistChip(
                    onClick = { },
                    label = { Text("Verificado", color = Color(0xFF00FF00), fontWeight = androidx.compose.ui.text.font.FontWeight.Bold) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = Color(0xFFF7F2FA)),
                    modifier = Modifier.widthIn(min = 90.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDangerZone(onLogoutClick: () -> Unit) {
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
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                "Cerrar sesión",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        }
    }
}
