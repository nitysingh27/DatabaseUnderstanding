package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel

@Composable
fun HomeScreen(
    viewModel: MainActivityViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Button(onClick = {
                viewModel.fixtureData.value = listOf()
                viewModel.getTimeZones()
                viewModel.getLeagues()
            }) {
                Text(text = "Click me to get data")
            }
        }
        item {

        }
        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                val list = viewModel.listOfTimeZones.value
                items(count = list.size, itemContent = {
                    Text(text = list[it], modifier = Modifier.padding(all = 20.dp))
                })
            }
        }
        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                val list = viewModel.leaguesList.value
                items(count = list.size, itemContent = {
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.absolutePadding(left = 5.dp, right = 5.dp).clickable {
                            viewModel.leagueSelected = list[it]
                            navHostController.navigate(Routes.teams)
                        }
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = rememberAsyncImagePainter(list[it].league.logo),
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(
                                text = list[it].league.name,
                                modifier = Modifier.padding(all = 20.dp)
                            )
                        }
                    }
                })
            }
        }

    }
}