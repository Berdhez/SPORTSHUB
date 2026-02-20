package com.ieschabas.sportshub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ieschabas.sportshub.ui.screens.*
import com.ieschabas.sportshub.ui.screens.classification.ClassificationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("about") { AboutScreen(navController) }
        composable("classification") { ClassificationScreen(navController) }
        composable("home") { DashboardScreen(navController) }
        composable("league") { LeagueDetailScreen(navController) }
        composable("leagues") { LeagueListScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("matches") { MatchesScreen(navController) }
        composable(
            "player/{playerId}",
            arguments = listOf(navArgument("playerId") { type = NavType.StringType })
        ) { backStackEntry ->
             val playerId = backStackEntry.arguments?.getString("playerId")
            PlayerDetailScreen(navController = navController)
        }

        composable("profile") { ProfileScreen(navController) }
        composable("register") { RegistrationScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("team") { TeamDetailScreen(navController) } // Usado por Dashboard
        composable("teamDetails/{teamId}",
            arguments = listOf(navArgument("teamId") { type = NavType.StringType })
        ) { backStackEntry ->
             val teamId = backStackEntry.arguments?.getString("teamId")
            TeamDetailScreen(navController = navController)
        }
        composable("teamsList") { TeamsListScreen(navController) }

        composable("classification/{leagueId}",
          arguments = listOf(navArgument("leagueId"){type = NavType.StringType})
        ){ ClassificationScreen(navController) }
    }
}