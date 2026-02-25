package com.ieschabas.sportshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ieschabas.sportshub.ui.screens.*
import com.ieschabas.sportshub.ui.screens.auth.AuthViewModel
import com.ieschabas.sportshub.ui.screens.classification.ClassificationScreen
import com.ieschabas.sportshub.ui.screens.leagueList.LeagueListScreen
import com.ieschabas.sportshub.ui.screens.match.MatchesScreen
import com.ieschabas.sportshub.ui.screens.player.PlayerDetailScreen
import com.ieschabas.sportshub.ui.screens.team.TeamDetailScreen
import com.ieschabas.sportshub.ui.screens.teamList.TeamsListScreen
import com.ieschabas.sportshub.ui.screens.user.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()

    // Si hay sesión activa, ir directamente a home; si no, a login
    val startDestination = if (authViewModel.isLoggedIn()) "home" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("about") { AboutScreen(navController) }
        composable("classification") { ClassificationScreen(navController) }
        composable("home") { DashboardScreen(navController) }
        composable("league") { LeagueDetailScreen(navController) }
        composable("leagues") { LeagueListScreen(navController) }
        composable("login") { LoginScreen(navController, authViewModel) }
        composable("matches") { MatchesScreen(navController) }
        composable(
            "player/{playerId}",
            arguments = listOf(navArgument("playerId") { type = NavType.StringType })
        ) { backStackEntry ->
            val playerId = backStackEntry.arguments?.getString("playerId") ?: ""
            PlayerDetailScreen(navController = navController, playerId = playerId)
        }
        composable("profile") { ProfileScreen(navController) }
        composable("register") { RegistrationScreen(navController, authViewModel) }
        composable("settings") { SettingsScreen(navController, authViewModel) }

        composable(
            "teamDetails/{teamId}",
            arguments = listOf(navArgument("teamId") { type = NavType.StringType })
        ) { backStackEntry ->
            val teamId = backStackEntry.arguments?.getString("teamId") ?: ""
            TeamDetailScreen(navController = navController, teamId = teamId)
        }
        composable("teamsList") { TeamsListScreen(navController) }

        composable(
            "classification/{leagueId}",
            arguments = listOf(navArgument("leagueId") { type = NavType.StringType })
        ) { ClassificationScreen(navController) }
    }
}