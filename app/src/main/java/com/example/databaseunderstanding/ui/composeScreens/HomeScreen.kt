package com.example.databaseunderstanding.ui.composeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    LaunchedEffect(key1 = true) {
        viewModel.getLeagues()
    }

    val list = viewModel.leaguesList.value
    LazyColumn(modifier = Modifier.fillMaxSize().background(color = Color.LightGray)) {
        items(count = list.size, itemContent = {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 10.dp, right = 10.dp, top = 5.dp, bottom = 5.dp)
                    .clickable {
                        viewModel.leagueSelected = list[it]
                        viewModel.selectedIndex.value = 3
                        navHostController.navigate(Routes.teams)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(top = 5.dp, bottom = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth(0.4f)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(list[it].league.logo),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = list[it].league.name
                            )
                            Text(
                                text = list[it].country.name
                            )
                        }
                        val seasons = list[it].seasons

                        for (s in seasons) {
                            Text(
                                text = "${s.start}  - ${s.end}",
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
        })
    }
}