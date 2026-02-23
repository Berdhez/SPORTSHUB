package com.ieschabas.sportshub.ui.screens.player

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ieschabas.sportshub.ui.components.*
import kotlinx.coroutines.launch

@Composable
fun PlayerDetailScreen(
    navController: NavController,
    playerId: String,
    viewModel: PlayerViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Cargar el jugador **una sola vez**
    var player by remember { mutableStateOf<com.ieschabas.sportshub.domain.model.Player?>(null) }

    LaunchedEffect(playerId) {
        player = viewModel.getPlayerById(playerId)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(navController = navController, onCloseDrawer = { scope.launch { drawerState.close() } })
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = player?.name ?: "Detalle del jugador",
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            bottomBar = { MyNavigationBar(navController = navController) }
        ) { padding ->
            if (player == null) {
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
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
                    PlayerInfoCard(
                        name = player!!.name,
                        number = player!!.number ?: 0,
                        position = player!!.position,
                        playerId = player!!.id
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    PlayerStat(label = "Posición", value = player!!.position)
                    PlayerStat(label = "Número", value = (player!!.number ?: 0).toString())
                    PlayerStat(label = "Nacionalidad", value = player!!.nationality ?: "-")
                }
            }
        }
    }
}