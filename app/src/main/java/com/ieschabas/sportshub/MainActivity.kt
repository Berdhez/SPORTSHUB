package com.ieschabas.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ieschabas.sportshub.ui.components.ClassificationItem
import com.ieschabas.sportshub.ui.screens.ClassificationScreen
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.LeagueDetailScreen
import com.ieschabas.sportshub.ui.screens.LeagueListScreen
import com.ieschabas.sportshub.ui.screens.LoginScreen


import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SPORTSHUBTheme {
                LoginScreen()
            }

        }
    }
}
