package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ieschabas.sportshub.ui.components.AppBottomBar
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.TeamsBox

data class Team(
    val nombre: String,
    val ciudad: String,
    val ies: String
)

@Composable
fun TeamsListScreen() {
    var selectedItem by remember { mutableStateOf(0) }

    val teams = listOf(
        Team("Equipo 1", "—", "—"),
        Team("Equipo 2", "—", "—"),
        Team("Equipo 3", "—", "—"),
        Team("Equipo 4", "—", "—"),
        Team("Equipo 5", "—", "—"),
        Team("Equipo 6", "—", "—")
    )

    Scaffold(
        topBar = {
            AppTopBar(title = "Equipos", onMenuClick = { /* Acción menú */ })
        },
        bottomBar = {
            AppBottomBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(teams) { team ->
                TeamsBox(equipo = team)
            }
        }
    }
}
