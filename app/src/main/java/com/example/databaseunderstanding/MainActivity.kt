package com.example.databaseunderstanding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.databaseunderstanding.ui.composeScreens.Navgraphs
import com.example.databaseunderstanding.ui.theme.DatabaseUnderstandingTheme
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val teamsViewModel : TeamsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatabaseUnderstandingTheme {
                val navController = rememberNavController()
                Navgraphs(navController,viewModel, teamsViewModel)
            }
        }
    }
}
