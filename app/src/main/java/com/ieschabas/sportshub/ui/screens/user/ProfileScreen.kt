package com.ieschabas.sportshub.ui.screens.user

import ProfileCard
import ProfileDangerZone
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: UserViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Iniciar la carga de datos del usuario
    LaunchedEffect(Unit) {
        viewModel.loadCurrentUser()
    }

    // Observar el estado del usuario desde el ViewModel
    val user by viewModel.user.collectAsState()

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
                AppTopBar(
                    title = "Mi cuenta",
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            bottomBar = {
                MyNavigationBar(navController = navController)
            }
        ) { innerPadding ->
            if (user == null) {
                // Mostramos un loading mientras carga
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                // UI principal con los datos del usuario
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))

                    ProfileCard(user = user!!)

                    Spacer(modifier = Modifier.height(24.dp))

                    ProfileDangerZone {
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    }
                }
            }
        }
    }
}