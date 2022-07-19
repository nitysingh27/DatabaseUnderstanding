package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel

@Composable
fun TeamsInLeague(
    teamsViewModel: TeamsViewModel = hiltViewModel(),
    homeViewModel: MainActivityViewModel = hiltViewModel(),
    navController: NavHostController
) {
    teamsViewModel.getTeamsInformation(homeViewModel.leagueSelected.league.id, 2021)
    LazyColumn {
        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                val list = teamsViewModel.teamsInformation.value
                items(count = list.size, itemContent = {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .absolutePadding(left = 5.dp, right = 5.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = rememberAsyncImagePainter(list[it].team.logo),
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(
                                text = list[it].team.name,
                                modifier = Modifier.padding(all = 20.dp)
                            )
                        }
                    }
                })
            }
        }
    }
}