package com.ieschabas.sportshub.ui.screens.match

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.MatchCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchesScreen(
    navController: NavController,
    viewModel: MatchViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // 🔥 Aquí está la magia
    val matches by viewModel.matches.collectAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                navController = navController,
                onCloseDrawer = {
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {

        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Partidos",
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
            }
        ) { innerPadding ->

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {

                if (matches.isEmpty()) {
                    item {
                        Text(
                            text = "No hay partidos disponibles",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                } else {
                    items(matches) { match ->
                        MatchCard(match = match)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}