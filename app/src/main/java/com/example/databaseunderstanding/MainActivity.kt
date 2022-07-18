package com.example.databaseunderstanding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.ui.theme.DatabaseUnderstandingTheme
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatabaseUnderstandingTheme {
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    item {
                        Button(onClick = {
                            viewModel.fixtureData.value = listOf()
                            viewModel.getFixtureData()
                            viewModel.getTimeZones()
                        }) {
                            Text(text = "Click me to get data")
                        }
                    }
                    item {
                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                            val list = viewModel.fixtureData.value
                            items(count = list.size, itemContent = {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .absolutePadding(
                                            left = 10.dp,
                                            right = 10.dp,
                                            bottom = 10.dp,
                                            top = 10.dp
                                        ), shape = RoundedCornerShape(20.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Image(
                                                painter = rememberAsyncImagePainter(list[it].teams.home.logo),
                                                contentDescription = null,
                                                modifier = Modifier.size(80.dp)
                                            )
                                            Spacer(modifier = Modifier.width(20.dp))
                                            Text(
                                                text = list[it].goals.home.toString(),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Text(text = "-", fontWeight = FontWeight.Bold)
                                        Row(verticalAlignment = Alignment.CenterVertically) {

                                            Text(
                                                text = list[it].goals.away.toString(),
                                                fontWeight = FontWeight.Bold
                                            )
                                            Spacer(modifier = Modifier.width(20.dp))
                                            Image(
                                                painter = rememberAsyncImagePainter(list[it].teams.away.logo),
                                                contentDescription = null,
                                                modifier = Modifier.size(80.dp)
                                            )
                                        }
                                    }
                                }
                            })
                        }
                    }
                    item {
                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                            val list = viewModel.listOfTimeZones.value
                            items(count = list.size, itemContent = {
                                Text(text = list[it], modifier = Modifier.padding(all = 20.dp))
                            })
                        }
                    }
                }
            }
        }
    }
}
