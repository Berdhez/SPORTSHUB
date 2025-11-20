package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ieschabas.sportshub.ui.components.Equipo
import com.ieschabas.sportshub.ui.components.TeamsBox

@Composable
fun TeamsListScreen() {
    val equipos = listOf(
        Equipo("Equipo 1", "—", "—"),
        Equipo("Equipo 2", "—", "—"),
        Equipo("Equipo 3", "—", "—"),
        Equipo("Equipo 4", "—", "—"),
        Equipo("Equipo 5", "—", "—"),
        Equipo("Equipo 6", "—", "—")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(equipos) { equipo ->
            TeamsBox(equipo = equipo)
        }
    }
}
