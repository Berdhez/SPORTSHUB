package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.AppBottomBar
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.matches.MatchCard
import com.ieschabas.sportshub.ui.model.Match
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchesScreen(navController: NavController) {
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
        var selectedItem by remember { mutableStateOf(2) }

        val matches = remember {
            (1..20).map {
                Match(
                    time = "Sab 20:${45 + it}",
                    homeTeam = "fx.home",
                    homeLogoRes = R.drawable.logo1, // tu logo local
                    awayTeam = "fx.away",
                    awayLogoRes = R.drawable.logo2, // tu logo local
                    score = if (it % 2 == 0) "0 - 0" else null
                )
            }
        }

        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Partidos",
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                AppBottomBar(
                    navController = navController,
                    selectedItem = selectedItem,
                    onItemSelected = { selectedItem = it }
                )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                items(matches) { match ->
                    MatchCard(match = match)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
