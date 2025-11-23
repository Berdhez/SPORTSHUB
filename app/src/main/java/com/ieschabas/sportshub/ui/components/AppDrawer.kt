package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppDrawer(
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "SportsHub Chabàs",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(modifier = Modifier.height(16.dp))
            NavigationDrawerItem(
                label = { Text("Ligas") },
                selected = false,
                onClick = { /* TODO */ }
            )
            NavigationDrawerItem(
                label = { Text("Equipos") },
                selected = false,
                onClick = { /* TODO */ }
            )
            NavigationDrawerItem(
                label = { Text("Partidos") },
                selected = false,
                onClick = { /* TODO */ }
            )
            NavigationDrawerItem(
                label = { Text("Clasificación") },
                selected = false,
                onClick = { /* TODO */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(modifier = Modifier.height(16.dp))
            NavigationDrawerItem(
                label = { Text("Inicio") },
                selected = false,
                onClick = { /* TODO */ },
                icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") }
            )
            NavigationDrawerItem(
                label = { Text("Perfil") },
                selected = false,
                onClick = { /* TODO */ },
                icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") }
            )
        }
    }
}
