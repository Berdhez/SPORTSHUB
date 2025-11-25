package com.ieschabas.sportshub.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.MyButton
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import com.ieschabas.sportshub.ui.navigation.MyNavigationBar
import com.ieschabas.sportshub.ui.theme.AzulPetroleo
import kotlinx.coroutines.launch

@Composable
fun LeagueDetailScreen() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {

    var selectedItem by remember { mutableStateOf(4) }

    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "Detalle de liga",
                navigationIcon = {
                    IconButton(onClick = { scope.launch {
                        drawerState.open()
                    }  }) {
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
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp),

            horizontalAlignment = Alignment.Start
        ) {

            Image(
                painter = painterResource(id = R.drawable.brand_liga_ieschabas),
                contentDescription = "Logo de la Liga",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )


            Text(
                text = "Liga: LaLiga",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Características de la liga (Liga de la marina alta)",
                fontSize = 14.sp,
                color = Color.Gray
            )


            Spacer(modifier = Modifier.height(24.dp))



            MyButton(
                text = "Ver clasificación",
                onClick = {  },

                backgroundColor = AzulPetroleo
            )
            Spacer(modifier = Modifier.height(12.dp))
            MyButton(
                text = "Ver partidos",
                onClick = {  },
                backgroundColor = Color(0xFF7E7280)
            )
        }
    }
}
}