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
import com.ieschabas.sportshub.ui.theme.AzulPetroleo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    // Estado para la navegación inferior
    var selectedItem by remember { mutableStateOf(3) } // Perfil por defecto seleccionado
    val items = listOf("Inicio", "Ligas", "Partidos", "Perfil")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.List,
        Icons.Filled.Star,
        Icons.Filled.Person

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mi cuenta", maxLines = 1) },
                navigationIcon = {
                    IconButton(onClick = { /* Acción del menú */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AzulPetroleo,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = AzulPetroleo,
                contentColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        alwaysShowLabel = true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.LightGray,
                            unselectedTextColor = Color.LightGray,
                            indicatorColor = Color.Green
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        // Contenido dinámico según el item seleccionado
        when (selectedItem) {
            0 -> Text("Pantalla de Inicio", modifier = Modifier.padding(innerPadding))
            1 -> Text("Pantalla de Ligas", modifier = Modifier.padding(innerPadding))
            2 -> Text("Pantalla de Partidos", modifier = Modifier.padding(innerPadding))
            3 -> Column(
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
}
