package com.ieschabas.sportshub.ui.screens.teamList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.TeamsBox
import kotlinx.coroutines.launch
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.ui.screens.TeamsListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsListScreen(
    navController: NavController,
    viewModel: TeamsListViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val teams by viewModel.teams.collectAsState() // 🟢 Usamos la base de datos

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(navController = navController) {
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(title = "Equipos", onMenuClick = { scope.launch { drawerState.open() } })
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(teams) { team ->
                    TeamsBox(equipo = team, onClick = {
                        navController.navigate("teamDetails/${team.id}")
                    })
                }
            }
        }
    }
}
