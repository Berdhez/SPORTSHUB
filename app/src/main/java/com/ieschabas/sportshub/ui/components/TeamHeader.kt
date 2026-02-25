package com.ieschabas.sportshub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme

@Composable
fun TeamHeader(
    teamName: String,
    coachName: String,
    stadiumName: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF5C5C7A),
                            Color(0xFFC4C4D4)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamLogo(modifier = Modifier.size(100.dp)) // logo a la izquierda
                Spacer(modifier = Modifier.width(24.dp))
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = teamName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Entrenador",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Entrenador: $coachName", color = Color.White, fontSize = 17.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = "Estadio",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = stadiumName, color = Color.White, fontSize = 17.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamHeaderPreview() {
    SPORTSHUBTheme {
        TeamHeader(
            teamName = "IES Chabàs",
            coachName = "A. Ortega",
            stadiumName = "Campo Municipal"
        )
    }
}
