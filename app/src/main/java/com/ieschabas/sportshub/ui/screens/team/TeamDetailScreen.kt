package com.ieschabas.sportshub.ui.screens.team

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.*
import kotlinx.coroutines.launch

@Composable
fun TeamDetailScreen(
    navController: NavController,
    teamId: String,
    viewModel: TeamViewModel = hiltViewModel()
) {

    // IMPORTANTE: cargar equipo por id
    LaunchedEffect(teamId) {
        viewModel.loadTeam(teamId)
    }

    val team by viewModel.team.collectAsState()
    val players by viewModel.players.collectAsState()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                navController = navController,
                onCloseDrawer = { scope.launch { drawerState.close() } }
            )
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = team?.name ?: "Detalle de equipo",
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
            }
        ) { padding ->

            if (team == null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {

                Column(
                    modifier = Modifier
                        .padding(padding)
                        .padding(horizontal = 27.dp, vertical = 17.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    TeamHeader(
                        teamName = team!!.name,
                        coachName = "Entrenador",
                        stadiumName = team!!.city
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TeamInfo(
                        coachName = "Entrenador",
                        stadiumName = team!!.city,
                        foundationYear = team!!.founded?.toString() ?: "-"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Plantilla",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    val playerUiList = players.map { p ->
                        Player(
                            id = p.id,
                            number = p.number ?: 0,
                            name = p.name,
                            position = p.position
                        )
                    }

                    PlayerList(
                        players = playerUiList,
                        onPlayerClick = { player ->
                            navController.navigate("player/${player.id}")
                        }
                    )
                }
            }
        }
    }
}