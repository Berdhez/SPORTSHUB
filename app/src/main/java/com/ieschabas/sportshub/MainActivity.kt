package com.ieschabas.sportshub
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ieschabas.sportshub.ui.components.ClassificationItem
import com.ieschabas.sportshub.ui.components.StatHighlightCard
import com.ieschabas.sportshub.ui.screens.AboutScreen
import com.ieschabas.sportshub.ui.screens.ClassificationScreen
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.LeagueDetailScreen
import com.ieschabas.sportshub.ui.screens.LeagueListScreen
import com.ieschabas.sportshub.ui.screens.LoginScreen
import com.ieschabas.sportshub.ui.theme.SPORTSHUBTheme
import com.ieschabas.sportshub.ui.screens.ProfileScreen
import com.ieschabas.sportshub.ui.screens.TeamsListScreen
import com.ieschabas.sportshub.ui.screens.MatchesScreen
import com.ieschabas.sportshub.ui.screens.PlayerDetailScreen
import com.ieschabas.sportshub.ui.screens.SettingsScreen
import com.ieschabas.sportshub.ui.screens.StatsHighlightsScreen
import com.ieschabas.sportshub.ui.screens.Team
import com.ieschabas.sportshub.ui.screens.TeamDetailScreen


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
