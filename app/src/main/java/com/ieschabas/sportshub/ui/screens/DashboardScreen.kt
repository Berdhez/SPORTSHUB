package com.ieschabas.sportshub.ui.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.DashboardCard
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import kotlinx.coroutines.launch


@Composable
fun DashboardScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(navController = navController,
                onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    title = "Sports Hub – IES Chabàs",
                    navigationIcon = {
                        IconButton(onClick = {scope.launch {
                            drawerState.open()
                        } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menú",
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            bottomBar = {
                MyNavigationBar(
                    navController = navController
                )
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row {
                    DashboardCard(
                        text = "Ligas",
                        backgroundColor = Color(0xFF4DB6AC),
                        onClick = {navController.navigate("leagues") },
                        modifier = Modifier.weight(1f)
                    )
                    DashboardCard(
                        text = "Equipos",
                        backgroundColor = Color(0xFF4FC3F7),
                        onClick = {navController.navigate("teamsList") },
                        modifier = Modifier.weight(1f)
                    )
                }

                Row {
                    DashboardCard(
                        text = "Partidos",
                        backgroundColor = Color.Green,
                        onClick = {navController.navigate("matches") },
                        modifier = Modifier.weight(1f)
                    )
                    DashboardCard(
                        text = "Clasificación",
                        backgroundColor = Color(0xFFC62828),
                        onClick = {navController.navigate("classification")},
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}