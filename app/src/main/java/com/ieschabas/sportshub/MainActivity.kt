package com.ieschabas.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import com.ieschabas.sportshub.ui.screens.ProfileScreen
import com.ieschabas.sportshub.ui.screens.TeamsListScreen
import com.ieschabas.sportshub.ui.screens.MatchesScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SPORTSHUBTheme {
                MatchesScreen()   // 👈 MOSTRARÁ ESTA PANTALLA AL INICIAR
            }
        }

    }
}