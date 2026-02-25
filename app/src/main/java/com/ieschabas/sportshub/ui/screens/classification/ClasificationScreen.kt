package com.ieschabas.sportshub.ui.screens.classification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.ClassificationRow
import com.ieschabas.sportshub.ui.components.MyNavigationBar
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue


data class TeamStats(
    val teamName: String,
    val pj: Int,
    val g: Int,
    val e: Int,
    val p: Int,
    val pts: Int,
    val logo: Int
)

@Composable
fun ClassificationScreen(navController: NavController,
    viewModel: ClassificationViewModel = hiltViewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val classifications by viewModel.classifications.collectAsState()
    val teams by viewModel.teams.collectAsState()
    val teamNameById = remember(teams) { teams.associateBy({ it.id }, { it.name }) }

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
                MyTopAppBar(
                    title = "Clasificación",
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú",
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            bottomBar = { MyNavigationBar(navController = navController) }
        ) { paddingValues ->

            val teamsData = remember(classifications) {
                classifications.map { c ->
                    TeamStats(
                        teamName = teamNameById[c.teamId] ?: c.teamId,
                        pj = c.gamesPlayed,
                        g = c.victories,
                        e = c.ties,
                        p = c.lost,
                        pts = c.totalPoints,
                        logo = R.drawable.escudo_ies_chabas
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    LazyColumn {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFF4DD0E1))
                                    .padding(horizontal = 8.dp, vertical = 12.dp),
                            ) {
                                Row(modifier = Modifier.weight(3f)) {
                                    Text(
                                        text = "Club",
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 32.dp + 8.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = "Equipo", fontWeight = FontWeight.Bold)
                                }
                                Row(
                                    modifier = Modifier.weight(2f),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("PJ", fontWeight = FontWeight.Bold)
                                    Text("G", fontWeight = FontWeight.Bold)
                                    Text("E", fontWeight = FontWeight.Bold)
                                    Text("P", fontWeight = FontWeight.Bold)
                                    Text("Pts", fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        items(teamsData.size) { index ->
                            ClassificationRow(
                                stats = teamsData[index],
                                rank = index + 1
                            )
                        }
                    }
                }
            }
        }
    }
}
