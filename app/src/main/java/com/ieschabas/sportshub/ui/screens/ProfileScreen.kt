package com.ieschabas.sportshub.ui.screens

import ProfileCard
import ProfileDangerZone
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ieschabas.sportshub.ui.components.AppBottomBar
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.theme.AzulPetroleo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var selectedItem by remember { mutableStateOf(3) } // Perfil seleccionado por defecto

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Mi cuenta",
                onMenuClick = { /* Acción menú */ }
            )
        },
        bottomBar = {
            AppBottomBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { innerPadding ->
        // Contenido dinámico según el item seleccionado
        Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(40.dp)) // Ajusta para que quede como en la imagen

                // Icono circular arriba
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    tint = Color(0XFFFF00FF), // color rosa/morado fuerte como en la imagen
                    modifier = Modifier
                        .size(90.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileCard()

                ProfileDangerZone(onLogoutClick = { /* acción cerrar sesión */ })
            }



        }
    }
