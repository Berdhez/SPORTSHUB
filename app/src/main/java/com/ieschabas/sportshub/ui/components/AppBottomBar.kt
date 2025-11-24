package com.ieschabas.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.ieschabas.sportshub.ui.theme.AzulPetroleo

@Composable
fun AppBottomBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf("Inicio", "Ligas", "Partidos", "Perfil")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.List,
        Icons.Filled.Star,
        Icons.Filled.Person
    )

    NavigationBar(
        containerColor = AzulPetroleo,
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
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
