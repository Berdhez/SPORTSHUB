package com.ieschabas.sportshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ieschabas.sportshub.ui.screens.AboutScreen
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
        startDestination = "teamsList"
    ) {
        composable("matches") { MatchesScreen(navController) }
        composable("login") { LoginScreen() }
        composable("profile") { ProfileScreen(navController) }
        composable("team") { TeamDetailScreen(navController) }
        composable("teamsList") { TeamsListScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("player") { PlayerDetailScreen(navController) }
        composable("home") { DashboardScreen(navController) }
        composable("leagues") { LeagueListScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable ("teamDetails/{teamId}",
            arguments = listOf(navArgument("teamId"){type= NavType.StringType})
        ){backStackEntry ->
            val teamId = backStackEntry.arguments?.getString("teamId")
            TeamDetailScreen(navController=navController)
        }
    }
}