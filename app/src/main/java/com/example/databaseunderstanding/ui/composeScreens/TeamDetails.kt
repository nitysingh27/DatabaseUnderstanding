package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel

@Composable
fun TeamDetails(
    navController: NavHostController,
    teamsViewModel: TeamsViewModel = hiltViewModel(),
    homeViewModel: MainActivityViewModel = hiltViewModel()
) {
    val selectedTeam = remember {
        teamsViewModel.teamStatisctis
    }
    LaunchedEffect(key1 = selectedTeam.value) {
        selectedTeam.value = teamsViewModel.getTeamDetails(
            teamsViewModel.clickedTeam.team.id,
            homeViewModel.leagueSelected.league.id,
            2021
        )
    }

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .absolutePadding(
                left = 10.dp,
                right = 10.dp,
                top = 10.dp,
                bottom = 10.dp
            )

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
            val venue = selectedTeam.value.biggest
            Image(
                painter = rememberAsyncImagePainter(team.logo),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Text(text = team.code)
            Text(text = team.name)
            Text(text = team.country)

            Spacer(modifier = Modifier.height(30.dp))

        }
    }

}