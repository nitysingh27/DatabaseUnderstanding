package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel

@Composable
fun Navgraphs(navController: NavHostController, viewModel: MainActivityViewModel) {


    NavHost(navController, Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navHostController = navController, viewModel = viewModel)
        }
        composable(Routes.teams) {
            TeamsInLeague(navController = navController, homeViewModel = viewModel)
        }
    }
}