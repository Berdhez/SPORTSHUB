package com.ieschabas.sportshub.ui.screens
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.ClassificationRow
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import com.ieschabas.sportshub.ui.components.TeamStats
import com.ieschabas.sportshub.ui.navigation.MyNavigationBar

@Composable
fun ClassificationScreen() {
    // CAMBIO: El ítem seleccionado es el 1 (Ligas)
    var selectedItem by remember { mutableStateOf(1) }

    val teamsData = remember {
        listOf(
            TeamStats("Equipo 1", 11, 7, 2, 2, 21, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 2", 12, 8, 2, 2, 22, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 3", 13, 6, 2, 2, 23, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 4", 14, 7, 2, 2, 24, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 5", 15, 8, 2, 2, 25, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 6", 16, 6, 2, 2, 26, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 7", 17, 7, 2, 2, 27, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 8", 18, 8, 2, 2, 28, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 9", 19, 6, 2, 2, 29, R.drawable.escudo_ies_chabas),
            TeamStats("Equipo 10", 20, 7, 2, 2, 30, R.drawable.escudo_ies_chabas)
        )
    }

    Scaffold(
        topBar = { MyTopAppBar(title = "Clasificación") },
        bottomBar = {
            MyNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->

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
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Row(
                                modifier = Modifier.weight(3f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Club",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 32.dp + 8.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Equipo",
                                    fontWeight = FontWeight.Bold
                                )
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
