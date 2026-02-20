package com.ieschabas.sportshub.ui.screens.leagueList
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.LeagueCard
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import kotlinx.coroutines.launch

@Composable
fun LeagueListScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                navController = navController,
                onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {
        val leagues = remember {
            listOf(
                "LaLiga", "Premier League", "Serie A", "Bundesliga", "Ligue 1", "Eredivisie"
            )
        }

        Scaffold(
            topBar = {
                MyTopAppBar(
                    title = "Ligas",
                    navigationIcon = {

                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
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

            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                items(leagues) { leagueName ->
                    LeagueCard(
                        leagueName = leagueName,
                        city = "—",
                        onClick = { 
                            navController.navigate("classification")
                        }
                    )
                }
            }
        }
    }
}