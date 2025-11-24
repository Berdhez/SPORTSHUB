package com.ieschabas.sportshub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ieschabas.sportshub.ui.theme.AzulPetroleo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onMenuClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title, maxLines = 1) },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
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
}
