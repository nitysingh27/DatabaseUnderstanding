package com.example.databaseunderstanding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.databaseunderstanding.ui.composeScreens.Navgraphs
import com.example.databaseunderstanding.ui.composeScreens.Routes
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
                Box(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    Navgraphs(navController, viewModel, teamsViewModel)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.leagues),
                            contentDescription = "cup",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable {
                                    navController.navigate(Routes.HOME)
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_player),
                            contentDescription = "player",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp).clickable {
                                    navController.navigate(Routes.teams)
                                }
                        )
                        Image(
                            painter = painterResource(id =R.drawable.ic_fixtures),
                            contentDescription = "fixtures",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp).clickable {
                                    navController.navigate(Routes.teamDetails)
                                }
                        )
                        Image(
                            painter = painterResource(id =R.drawable.ic_teams),
                            contentDescription = "team",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp).clickable {
                                    navController.navigate(Routes.teams)
                                }
                        )
                    }
                }

            }
        }
    }
}
