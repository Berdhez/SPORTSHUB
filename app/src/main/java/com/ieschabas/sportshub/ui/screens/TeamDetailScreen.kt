package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieschabas.sportshub.ui.components.AppBottomBar
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.Player
import com.ieschabas.sportshub.ui.components.PlayerList
import com.ieschabas.sportshub.ui.components.TeamHeader
import com.ieschabas.sportshub.ui.components.TeamInfo
import com.ieschabas.sportshub.ui.components.TeamStats
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import kotlinx.coroutines.launch

@Composable
fun TeamDetailScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {
        var selectedItem by remember { mutableStateOf(0) }
        Scaffold(
            topBar = {
                AppTopBar(title = "Detalle de equipo", onMenuClick = {
                    scope.launch {
                        drawerState.open()
                    }
                })
            },
            bottomBar = {
                AppBottomBar(selectedItem = selectedItem, onItemSelected = { selectedItem = it })
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 27.dp, vertical = 17.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TeamHeader(
                    teamName = "IES Chabàs",
                    coachName = "A. Ortega",
                    stadiumName = "Campo Municipal"
                )
                Spacer(modifier = Modifier.height(16.dp))
                TeamStats(points = 27, won = 8, drawn = 3, lost = 2)
                Spacer(modifier = Modifier.height(16.dp))
                TeamInfo(
                    coachName = "A. Ortega",
                    stadiumName = "Campo Municipal",
                    foundationYear = "2004"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Plantilla",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                val players = listOf(
                    Player(1, "Marcos Pérez", "Portero"),
                    Player(2, "Otro Jugador", "Defensa")
                )
                PlayerList(players = players)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamDetailScreenPreview() {
    SPORTSHUBTheme {
        TeamDetailScreen()
    }
}
