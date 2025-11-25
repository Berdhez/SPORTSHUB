package com.ieschabas.sportshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.LeagueListScreen
import com.ieschabas.sportshub.ui.screens.LoginScreen
import com.ieschabas.sportshub.ui.screens.MatchesScreen
import com.ieschabas.sportshub.ui.screens.PlayerDetailScreen
import com.ieschabas.sportshub.ui.screens.ProfileScreen
import com.ieschabas.sportshub.ui.screens.SettingsScreen
import com.ieschabas.sportshub.ui.screens.TeamDetailScreen
import com.ieschabas.sportshub.ui.screens.TeamsListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {
        composable("matches") { MatchesScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("team") { TeamDetailScreen(navController) }
        composable("teamsList") { TeamsListScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("player") { PlayerDetailScreen(navController) }
        composable("home") { DashboardScreen(navController) }
        composable("leagues") { LeagueListScreen(navController) }
    }
}