package com.ieschabas.sportshub.ui.components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)


val bottomNavItems = listOf(
    BottomNavigationItem("Inicio", Icons.Default.Home, "home"),
    BottomNavigationItem("Ligas", Icons.AutoMirrored.Filled.List, "leagues"),
    BottomNavigationItem("Partidos", Icons.Default.Star, "matches"),
    BottomNavigationItem("Perfil", Icons.Default.Person, "profile")
)
