package com.ieschabas.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.theme.AzulPetroleo

@Composable
fun AppBottomBar(
    navController: NavController,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf("Inicio", "Ligas", "Partidos", "Perfil")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.AutoMirrored.Filled.List,
        Icons.Filled.Star,
        Icons.Filled.Person
    )
    val routes = listOf("home", "leagues", "matches", "profile")

    NavigationBar(
        containerColor = AzulPetroleo,
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index)
                    navController.navigate(routes[index]){
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true}
                            restoreState = true
                        }
                    },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = Color.Green
                )
            )
        }
    }
}
