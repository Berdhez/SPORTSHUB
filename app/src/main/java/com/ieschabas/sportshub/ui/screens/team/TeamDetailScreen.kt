package com.ieschabas.sportshub.ui.screens.team

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.Player
import com.ieschabas.sportshub.ui.components.PlayerList
import com.ieschabas.sportshub.ui.components.TeamHeader
import com.ieschabas.sportshub.ui.components.TeamInfo
import com.ieschabas.sportshub.ui.components.TeamStats
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import kotlinx.coroutines.launch

@Composable
fun TeamDetailScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer( navController = navController,
                onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(title = "Detalle de equipo", onMenuClick = {
                    scope.launch {
                        drawerState.open()
                    }
                })
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
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
                PlayerList(players = players, onPlayerClick = {
                    navController.navigate("player/${it.number}")
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamDetailScreenPreview() {
    val navController = rememberNavController()
    SPORTSHUBTheme {
        TeamDetailScreen(
            navController = navController
        )
    }
}
