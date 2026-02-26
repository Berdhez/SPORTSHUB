package com.ieschabas.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ieschabas.sportshub.ui.theme.AzulPetroleo

data class NavItem(val label: String, val icon: ImageVector, val route: String)

@Composable
fun MyNavigationBar(
    navController: NavController
) {
    val items = listOf(
        NavItem(label = "Inicio", icon = Icons.Default.Home, route = "home"),
        NavItem(label = "Ligas", icon = Icons.AutoMirrored.Filled.List, route = "leagues"),
        NavItem(label = "Partidos", icon = Icons.Default.Star, route = "matches"),
        NavItem(label = "Perfil", icon = Icons.Default.Person, route = "profile")
    )

    NavigationBar(
        containerColor = AzulPetroleo
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo("home") {
                            saveState = true
                            inclusive = false
                        }


                    }

                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.LightGray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = AzulPetroleo
                )
            )
        }
    }
}
