package com.ieschabas.sportshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ieschabas.sportshub.ui.screens.RegistrationScreen
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SPORTSHUBTheme {
                RegistrationScreen()
            }
        }
    }
}