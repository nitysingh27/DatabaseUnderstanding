package com.example.databaseunderstanding.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    val teamsInformation = mutableStateOf<List<TeamsInformation>>(listOf())
    fun getTeamsInformation(leagueId: Int, year: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            teamsInformation.value = teamsRepository.getTeamInformation(leagueId, year)
        }
    }
}