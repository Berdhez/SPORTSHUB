package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.MyTopAppBar
@Preview
@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "Acerca de Sports Hub",
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_chabas),
                contentDescription = "Logo de la App",
                modifier = Modifier.height(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sports Hub",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Versión 1.0.0",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Esta aplicación ha sido desarrollada como proyecto para la asignatura de Programación Multimedia y Dispositivos Móviles del IES Historiador Chabàs.",
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Desarrollado por:",
                fontWeight = FontWeight.SemiBold
            )
            Text(text = "Bernardo Hernández y Josep Navarro")
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
