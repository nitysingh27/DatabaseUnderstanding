package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.model.teams.TeamsInformation
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel

@Composable
fun TeamsInLeague(
    teamsViewModel: TeamsViewModel = hiltViewModel(),
    homeViewModel: MainActivityViewModel = hiltViewModel(),
    navController: NavHostController
) {
    teamsViewModel.getTeamsInLeague(homeViewModel.leagueSelected.league.id, 2021)
    val selectedTeam = remember {
        mutableStateOf(TeamsInformation())
    }
    Row(modifier = Modifier.fillMaxSize()) {
        val list = teamsViewModel.teamsInLeague.value
        if (list.isNotEmpty()) {
            LazyColumn {
                items(count = list.size, itemContent = {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .width(200.dp)
                            .absolutePadding(left = 5.dp, right = 5.dp, top = 10.dp, bottom = 10.dp)
                            .clickable {
                                selectedTeam.value = list[it]
                            }
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
        } else {
            Text(text = "No data")
        }
        if (selectedTeam.value != TeamsInformation()) {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .absolutePadding(
                        left = 10.dp,
                        right = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                    .clickable {
                        teamsViewModel.clickedTeam = selectedTeam.value
                        navController.navigate(Routes.teamDetails)
                    }
            ) {
                Column(
                    modifier = Modifier.absolutePadding(
                        left = 10.dp,
                        right = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val team = selectedTeam.value.team
                    val venue = selectedTeam.value.venue
                    Image(
                        painter = rememberAsyncImagePainter(team.logo),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(text = team.code)
                    Text(text = team.name)
                    Text(text = team.country)

                    Spacer(modifier = Modifier.height(30.dp))
                    Image(
                        painter = rememberAsyncImagePainter(venue.image),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(text = venue.name)
                    Text(text = venue.address)
                    Text(text = venue.city)
                    Text(text = venue.surface)
                    Text(text = venue.capacity.toString())


                }
            }
        }
    }
}