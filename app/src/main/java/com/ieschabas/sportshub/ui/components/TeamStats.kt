package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.ui.components.navItems
import com.ieschabas.sportshub.ui.theme.AzulPetroleo
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme


@Composable
fun TeamStats(
    points: Int,
    won: Int,
    drawn: Int,
    lost: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        StatChip(label = "Pts $points")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "G $won")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "E $drawn")
        Spacer(modifier = Modifier.width(8.dp))
        StatChip(label = "P $lost")
    }
}

@Composable
fun StatChip(label: String) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8E8E8))
    ) {
        Text(
            text = label,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamStatsPreview() {
    SPORTSHUBTheme {
        TeamStats(points = 27, won = 8, drawn = 3, lost = 2)
    }
}

@Composable
fun MyNavigationBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = AzulPetroleo
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.LightGray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.LightGray,
                    indicatorColor = Color.Green
                )
            )
        }
    }
}

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