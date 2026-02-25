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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.DashboardCard
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import kotlinx.coroutines.launch

@Preview
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
                        onClick = { navController.navigate("leagues") },
                        modifier = Modifier.weight(1f),
                        lottieUrl = "https://lottie.host/0b274f41-e9a0-481c-9f7e-230c7391d12d/k7JOZRQzqh.lottie",
                        lottieOffsetY = 20.dp,
                        textColor = Color.Black,
                        contentAlignment = Alignment.BottomCenter,
                        textPaddingBottom = 40.dp
                    )
                    DashboardCard(
                        text = "Equipos",
                        backgroundColor = Color(0xFF4FC3F7),
                        onClick = { navController.navigate("teamsList") },
                        modifier = Modifier.weight(1f),
                        lottieUrl = "https://lottie.host/969934ad-ba54-4065-8406-dd0579a58ba2/GYoMAbZdg8.lottie",
                        lottieSpeed = 0.4f,
                        lottieAlpha = 1f,
                        textColor = Color.Black,
                        contentAlignment = Alignment.BottomCenter,
                        textPaddingBottom = 40.dp
                    )
                }

                Row {
                    DashboardCard(
                        text = "Partidos",
                        backgroundColor = Color.Green,
                        onClick = { navController.navigate("matches") },
                        modifier = Modifier.weight(1f),
                        lottieUrl = "https://lottie.host/7005fcf4-c8d9-4bdf-8954-de0a751746ff/EYOr7KjXYf.lottie",
                        textColor = Color.Black,
                        contentAlignment = Alignment.BottomCenter,
                        textPaddingBottom = 40.dp
                    )
                    DashboardCard(
                        text = "Clasificación",
                        backgroundColor = Color(0xFFC62828),
                        onClick = { navController.navigate("classification") },
                        modifier = Modifier.weight(1f),
                        lottieUrl = "https://lottie.host/8757a01f-9e1d-4b12-a7b0-c5e81e3305e7/Y30izsifgK.lottie",
                        textColor = Color.Black,
                        contentAlignment = Alignment.BottomCenter,
                        textPaddingBottom = 40.dp
                    )
                }

                Row {
                    DashboardCard(
                        text = "Multimedia",
                        backgroundColor = Color(0xFF7B1FA2),
                        onClick = { navController.navigate("multimedia") },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}