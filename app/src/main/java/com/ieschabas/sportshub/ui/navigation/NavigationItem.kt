package com.ieschabas.sportshub.ui.navigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector


data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)


val navItems = listOf(
    NavigationItem("Inicio", Icons.Default.Home, "home"),
    NavigationItem("Ligas", Icons.AutoMirrored.Filled.List, "leagues"),
    NavigationItem("Partidos", Icons.Default.Star, "matches"),
    NavigationItem("Perfil", Icons.Default.Person, "profile")
)
