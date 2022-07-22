package com.example.databaseunderstanding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.databaseunderstanding.model.BottomNavBarItem
import com.example.databaseunderstanding.ui.composeScreens.Navgraphs
import com.example.databaseunderstanding.ui.composeScreens.Routes
import com.example.databaseunderstanding.ui.theme.DatabaseUnderstandingTheme
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import com.example.databaseunderstanding.viewmodel.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val teamsViewModel : TeamsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mCalendar = Calendar.getInstance()
        viewModel.mYear.value = mCalendar.get(Calendar.YEAR)
        viewModel.mMonth.value = mCalendar.get(Calendar.MONTH)
        viewModel.mDay.value = mCalendar.get(Calendar.DAY_OF_MONTH)

        viewModel.getBottomNavItems()
        setContent {
            DatabaseUnderstandingTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    Navgraphs(navController, viewModel, teamsViewModel)
                    BotNavBar(
                        navController, modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .absolutePadding(left = 10.dp, right = 10.dp, bottom = 10.dp)
                    )
                }

            }
        }
    }

    @Composable
    private fun BotNavBar(navController: NavHostController, modifier: Modifier) {
        Card(modifier = modifier, shape = RoundedCornerShape(10.dp), elevation = 10.dp) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for(index in 0 until viewModel.botNavItems.value.size) {
                    BottomNavBarItem(
                        navController,
                        viewModel.selectedIndex,
                        viewModel.botNavItems.value[index],
                        index
                    )
                }
            }
        }
    }

    @Composable
    private fun BottomNavBarItem(
        navController: NavHostController,
        selectedIndex: MutableState<Int>,
        item: BottomNavBarItem,
        pos: Int
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp).clickable {
            navController.navigate(item.destination)
            selectedIndex.value = pos
        }) {
            Image(
                painter = painterResource(id = item.drawable),
                contentDescription = "cup",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                colorFilter = ColorFilter.tint(
                    if (selectedIndex.value == pos) Color(
                        0xFF6161ED
                    ) else Color.LightGray
                )
            )
            Text(text = item.label)
        }
    }
}
