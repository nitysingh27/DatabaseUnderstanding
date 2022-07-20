package com.example.databaseunderstanding.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databaseunderstanding.model.teams.Team
import com.example.databaseunderstanding.model.teams.TeamStatisticsResponse
import com.example.databaseunderstanding.model.teams.TeamsInformation
import com.example.databaseunderstanding.repository.team.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel
@Inject
constructor(
    private val teamsRepository: TeamRepository
) : ViewModel() {

    var clickedTeam: TeamsInformation = TeamsInformation()
    val teamsInLeague = mutableStateOf<List<TeamsInformation>>(listOf())
    fun getTeamsInLeague(leagueId: Int, year: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            teamsInLeague.value = teamsRepository.getTeamsInLeague(leagueId, year)
        }
    }

    val teamStatisctis = mutableStateOf(TeamStatisticsResponse())
    fun getTeamDetails(teamId : Int, leagueId: Int, year: Int) : TeamStatisticsResponse{
        viewModelScope.launch(Dispatchers.IO) {
            teamStatisctis.value = teamsRepository.getTeamDetails(teamId, year, leagueId )
        }
        return teamStatisctis.value
    }
}