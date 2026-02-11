package com.ieschabas.sportshub.ui.screens.user

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
import androidx.navigation.NavController
import com.ieschabas.sportshub.ui.components.AppBottomBar
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
        var selectedItem by remember { mutableStateOf(3) }

        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Mi cuenta",
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                AppBottomBar(
                    navController = navController,
                    selectedItem = selectedItem,
                    onItemSelected = { selectedItem = it }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    tint = Color(0XFFFF00FF),
                    modifier = Modifier
                        .size(90.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileCard()

                ProfileDangerZone(onLogoutClick = {
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                })
            }
        }
    }
}
