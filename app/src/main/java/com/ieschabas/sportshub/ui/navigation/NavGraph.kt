package com.ieschabas.sportshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ieschabas.sportshub.ui.screens.AboutScreen
import com.ieschabas.sportshub.ui.screens.ClassificationScreen
import com.ieschabas.sportshub.ui.screens.DashboardScreen
import com.ieschabas.sportshub.ui.screens.LeagueDetailScreen
import com.ieschabas.sportshub.ui.screens.LeagueListScreen
import com.ieschabas.sportshub.ui.screens.LoginScreen
import com.ieschabas.sportshub.ui.screens.MatchesScreen
import com.ieschabas.sportshub.ui.screens.PlayerDetailScreen
import com.ieschabas.sportshub.ui.screens.ProfileScreen
import com.ieschabas.sportshub.ui.screens.RegistrationScreen
import com.ieschabas.sportshub.ui.screens.SettingsScreen

import com.ieschabas.sportshub.ui.screens.TeamDetailScreen
import com.ieschabas.sportshub.ui.screens.TeamsListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("matches") { MatchesScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("team") { TeamDetailScreen(navController) }
        composable("teamsList") { TeamsListScreen(navController) }
        composable("leagueList") { LeagueListScreen(navController) }
        composable("home") { DashboardScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegistrationScreen(navController) }
        composable("clasification") { ClassificationScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("league") { LeagueDetailScreen(navController) }



    }
}