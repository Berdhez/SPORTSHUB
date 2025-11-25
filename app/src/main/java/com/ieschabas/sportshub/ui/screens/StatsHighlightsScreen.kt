package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import com.ieschabas.sportshub.ui.components.StatHighlightCard
import com.ieschabas.sportshub.ui.components.MyNavigationBar

@Preview
@Composable
fun StatsHighlightsScreen() {
    var selectedItem by remember { mutableStateOf(2) }
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "Estadísticas Destacadas",
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú",
                            tint = Color.White
                        )
                    }
                }
            )
        },
                bottomBar = {
            MyNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                StatHighlightCard(
                    icon = Icons.AutoMirrored.Filled.TrendingUp,
                    category = "Máximo Goleador",
                    name = "Marc Llopis",
                    value = "15 Goles",
                    imageRes = R.drawable.jugador1
                )
            }
            item {
                StatHighlightCard(
                    icon = Icons.Default.Shield,
                    category = "Portero Menos Goleado",
                    name = "Teresa Rodríguez",
                    value = "0.5 G/P",
                    imageRes = R.drawable.jugadora1
                )
            }
            item {
                StatHighlightCard(
                    icon = Icons.Default.WorkspacePremium,
                    category = "Equipo con más victorias",
                    name = "IES Chabás",
                    value = "12 V",
                    imageRes = R.drawable.escudo_ies_chabas
                )
            }
        }
    }
}
