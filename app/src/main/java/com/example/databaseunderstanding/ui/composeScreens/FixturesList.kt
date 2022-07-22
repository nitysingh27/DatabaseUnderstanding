package com.example.databaseunderstanding.ui.composeScreens

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.databaseunderstanding.R
import com.example.databaseunderstanding.model.fixture.FixtureItem
import com.example.databaseunderstanding.util.Utilities
import com.example.databaseunderstanding.viewmodel.MainActivityViewModel
import java.util.*

@Composable
fun FixturesList(navController: NavHostController, homeViewModel: MainActivityViewModel) {
    val date = remember {
        mutableStateOf(Utilities.getCurrentDate())
    }
    LaunchedEffect(key1 = date.value) {
        Log.d("FixturesList", "FixturesList: Called")
        homeViewModel.getFixtureData(date.value)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        val mContext = LocalContext.current
        val mYear = remember {
            mutableStateOf(0)
        }
        val mMonth = remember {
            mutableStateOf(0)
        }
        val mDay = remember {
            mutableStateOf(0)
        }

        val mCalendar = Calendar.getInstance()
        mYear.value = mCalendar.get(Calendar.YEAR)
        mMonth.value = mCalendar.get(Calendar.MONTH)
        mDay.value = mCalendar.get(Calendar.DAY_OF_MONTH)

        mCalendar.time = Date()
        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, Year: Int, mMonths: Int, mDayOfMonth: Int ->
                val month = if (mMonths < 10) "0$mMonths" else mMonths.toString()
                val day = if (mDayOfMonth < 10) "0$mDayOfMonth" else mDayOfMonth.toString()
                date.value = "$Year-$month-$day"
            }, mYear.value, mMonth.value, mDay.value
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable {
                mDatePickerDialog.show()
            }
            .background(color = Color.Cyan),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mDay.value.toString(),
                color = Color.White
            )
            Text(
                text = mMonth.value.toString(),
                color = Color.White
            )
            Text(
                text = mYear.value.toString(),
                color = Color.White
            )
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val mappedList = homeViewModel.mappedFixtureList.value
            for (mappedItems in mappedList.iterator()) {
                item {
                    Column {
                        val itemVisibility = remember {
                            mutableStateOf(false)
                        }

                        val mappedListEach = remember {
                            mutableStateOf(listOf<FixtureItem>())
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .absolutePadding(left = 10.dp, right = 10.dp)
                                .background(
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable {
                                    itemVisibility.value = !itemVisibility.value
                                    mappedListEach.value = mappedItems.value
                                },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = mappedItems.key,
                                fontSize = 26.sp,
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(0.8f)
                                    .absolutePadding(left = 10.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                                contentDescription = "dropDown"
                            )
                        }
                        if (mappedListEach.value.isNotEmpty()) {
                            AnimatedVisibility(visible = itemVisibility.value) {
                                LazyRow(modifier = Modifier.fillMaxWidth()) {
                                    items(count = mappedListEach.value.size, itemContent = {
                                        val fixtureItem = mappedListEach.value[it]
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .absolutePadding(
                                                    left = 30.dp,
                                                    right = 30.dp,
                                                    bottom = 10.dp,
                                                    top = 10.dp
                                                ), shape = RoundedCornerShape(20.dp)
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .absolutePadding(
                                                        left = 10.dp,
                                                        right = 10.dp,
                                                        bottom = 10.dp,
                                                        top = 10.dp
                                                    ),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Image(
                                                        painter = rememberAsyncImagePainter(
                                                            fixtureItem.teams.home.logo
                                                        ),
                                                        contentDescription = null,
                                                        modifier = Modifier.size(50.dp)
                                                    )
                                                    Spacer(modifier = Modifier.width(20.dp))
                                                    Text(
                                                        text = fixtureItem.goals.home.toString(),
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Text(text = "-", fontWeight = FontWeight.Bold)
                                                Row(verticalAlignment = Alignment.CenterVertically) {

                                                    Text(
                                                        text = fixtureItem.goals.away.toString(),
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Spacer(modifier = Modifier.width(20.dp))
                                                    Image(
                                                        painter = rememberAsyncImagePainter(
                                                            fixtureItem.teams.away.logo
                                                        ),
                                                        contentDescription = null,
                                                        modifier = Modifier.size(80.dp)
                                                    )
                                                }
                                            }
                                        }
                                    })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
