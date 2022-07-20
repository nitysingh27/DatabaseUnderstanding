package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel

@Composable
fun Navgraphs(navController: NavHostController, viewModel: MainActivityViewModel, teamsViewModel: TeamsViewModel) {


    NavHost(navController, Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navHostController = navController, viewModel = viewModel)
        }
        composable(Routes.teams) {
            TeamsInLeague(navController = navController, homeViewModel = viewModel)
        }
        composable(Routes.teamDetails) {
            TeamDetails(navController = navController, teamsViewModel = teamsViewModel, homeViewModel = viewModel)
        }
    }
}