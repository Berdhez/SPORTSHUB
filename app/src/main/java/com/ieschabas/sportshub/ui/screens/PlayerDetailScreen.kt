package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.PlayerInfoCard
import com.ieschabas.sportshub.ui.components.PlayerStat
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerDetailScreen(navController: NavController) {
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
                AppTopBar(
                    title = "Detalles del Jugador",
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                PlayerInfoCard(
                    name = "Carlos Pérez",
                    number = 10,
                    position = "Centrocampista"
                )
                PlayerStat(label = "Edad", value = "17")
                PlayerStat(label = "Curso", value = "2º Bachillerato")
                PlayerStat(label = "Instituto", value = "IES Chabàs")
                PlayerStat(label = "Goles", value = "8")
                PlayerStat(label = "Partidos Jugados", value = "12")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerDetailScreenPreview() {
    val navController = rememberNavController()
    SPORTSHUBTheme {
        PlayerDetailScreen(
            navController = navController
        )
    }
}
