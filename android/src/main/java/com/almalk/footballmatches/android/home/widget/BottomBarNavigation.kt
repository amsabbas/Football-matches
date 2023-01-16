package com.almalk.footballmatches.android.home.widget

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.almalk.footballmatches.android.home.model.BottomItemNavigationModel
import com.almalk.footballmatches.android.matches.screen.MatchesScreen
import com.almalk.footballmatches.android.teams.screen.TeamsScreen


@Composable
fun BottomBarNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomItemNavigationModel.Matches.route
    ) {

        composable(BottomItemNavigationModel.Matches.route) {
            MatchesScreen()
        }

        composable(BottomItemNavigationModel.Teams.route) {
            TeamsScreen()
        }
    }
}