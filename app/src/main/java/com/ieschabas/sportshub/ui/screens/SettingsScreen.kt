package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ieschabas.sportshub.ui.components.AppDrawer
import com.ieschabas.sportshub.ui.components.AppTopBar
import com.ieschabas.sportshub.ui.components.ButtonSettingItem
import com.ieschabas.sportshub.ui.components.InfoSettingItem
import com.ieschabas.sportshub.ui.components.SectionTitle
import com.ieschabas.sportshub.ui.components.SwitchSettingItem
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer( navController = navController,
                onCloseDrawer = {
                scope.launch {
                    drawerState.close()
                }
            })
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = "Ajustes",
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                SectionTitle("General")
                SwitchSettingItem(title = "Modo Oscuro", initialChecked = false)
                SwitchSettingItem(title = "Activar Notificaciones", initialChecked = true)
                ButtonSettingItem(title = "Gestionar cuenta",
                    onClick = { /* TODO */ })

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("Datos y sincronización")
                SwitchSettingItem(title = "Sincronización Automática", initialChecked = true)
                SwitchSettingItem(title = "Descargar solo con Wi-Fi", initialChecked = true)
                ButtonSettingItem(title = "Borrar caché",
                    onClick = { /* TODO */ })

                Spacer(modifier = Modifier.height(16.dp))


                ButtonSettingItem(title = "Acerca de",
                    onClick = { navController.navigate("about") }
                )
                InfoSettingItem(title = "Política de privacidad")
                InfoSettingItem(title = "Términos de servicio")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    SPORTSHUBTheme {
        SettingsScreen(
            navController = navController
        )
    }
}
