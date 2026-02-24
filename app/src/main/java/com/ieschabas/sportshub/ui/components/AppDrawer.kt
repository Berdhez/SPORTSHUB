package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import androidx.navigation.NavController

@Composable
fun AppDrawer(navController: NavController,
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
                onClick = { navController.navigate("leagues")}
            )
            NavigationDrawerItem(
                label = { Text("Equipos") },
                selected = false,
                onClick = { navController.navigate("teamsList")}
            )
            NavigationDrawerItem(
                label = { Text("Partidos") },
                selected = false,
                onClick = { navController.navigate("matches") }
            )
            NavigationDrawerItem(
                label = { Text("Clasificación") },
                selected = false,
                onClick = { navController.navigate("classification")}
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(modifier = Modifier.height(16.dp))
            NavigationDrawerItem(
                label = { Text("Inicio") },
                selected = false,
                onClick = {navController.navigate("home")},
                icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") }
            )
            NavigationDrawerItem(
                label = { Text("Perfil") },
                selected = false,
                onClick = { navController.navigate("profile") },
                icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") }
            )
            NavigationDrawerItem(
                label = { Text("Ajustes") },
                selected = false,
                onClick = {navController.navigate("settings")},
                icon = { Icon(Icons.Default.Settings, contentDescription = "Ajustes") }
            )
        }
    }
}
