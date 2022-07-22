package com.example.databaseunderstanding.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseunderstanding.R
import com.example.databaseunderstanding.model.BottomNavBarItem
import com.example.databaseunderstanding.model.fixture.FixtureItem
import com.example.databaseunderstanding.model.leagues.LeagueResponse
import com.example.databaseunderstanding.repository.fixtures.FixtureRepository
import com.example.databaseunderstanding.repository.league.LeagueRepository
import com.example.databaseunderstanding.repository.team.TeamRepository
import com.example.databaseunderstanding.repository.timeZone.TimeZoneRepository
import com.example.databaseunderstanding.ui.composeScreens.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val mainRepository: FixtureRepository,
    private val timeZoneRepository: TimeZoneRepository,
    private val leagueRepository: LeagueRepository,
    private val teamRepository: TeamRepository
) : ViewModel() {
    var leagueSelected: LeagueResponse = LeagueResponse()
    val fixtureData = mutableStateOf<List<FixtureItem>>(listOf())
    val listOfTimeZones = mutableStateOf<List<String>>(listOf())
    val botNavItems = mutableStateOf<List<BottomNavBarItem>>(listOf())
    val mappedFixtureList = mutableStateOf<Map<String, ArrayList<FixtureItem>>>(HashMap())
    val selectedIndex = mutableStateOf(0)
    val mYear = mutableStateOf(0)
    val mMonth = mutableStateOf(0)
    val mDay = mutableStateOf(0)

    fun getBottomNavItems() {
        val list = ArrayList<BottomNavBarItem>()
        list.add(
            BottomNavBarItem(
                drawable = R.drawable.leagues,
                label = "Leagues",
                destination = Routes.HOME
            )
        )
        list.add(
            BottomNavBarItem(
                R.drawable.ic_player,
                "Player",
                Routes.teams,
            )
        )
        list.add(
            BottomNavBarItem(
                R.drawable.ic_fixtures,
                "Fixture",
                Routes.FIXTURES,
            )
        )
        list.add(
            BottomNavBarItem(
                R.drawable.ic_teams,
                "Teams",
                Routes.teams,
            )
        )
        botNavItems.value = list
    }

    val cost = "Cost"
    fun getFixtureData(date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val t = mainRepository.getFixtures(date)
            fixtureData.value = t
            try {
                val map = HashMap<String, ArrayList<FixtureItem>>()
                for (fix in t) {
                    val ls = map.get(fix.league.name)
                    ls?.add(fix)
                    map[fix.league.name] = ls ?: ArrayList()
                    val result = map.toList().sortedByDescending { (_, value) -> value.size}.toMap()
                    mappedFixtureList.value = result
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getTimeZones() {
        viewModelScope.launch(Dispatchers.IO) {
            val times = timeZoneRepository.getTimeZones()
            if(times.isNotEmpty()) {
                listOfTimeZones.value = times[0].response
            }
        }
    }

    val leaguesList = mutableStateOf<List<LeagueResponse>>(listOf())
    fun getLeagues() {
        viewModelScope.launch(Dispatchers.IO) {
            leaguesList.value = leagueRepository.getLeagues()
        }
    }


}