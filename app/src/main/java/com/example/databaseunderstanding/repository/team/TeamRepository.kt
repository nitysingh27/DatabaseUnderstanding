package com.example.databaseunderstanding.repository.team

import android.util.Log
import com.example.databaseunderstanding.model.teams.TeamStatisticsResponse
import com.example.databaseunderstanding.model.teams.TeamStatisticsResponseModel
import com.example.databaseunderstanding.model.teams.TeamsInformation
import com.example.databaseunderstanding.model.teams.TeamsInformationResponseModel
import com.example.databaseunderstanding.retrofit.teams.TeamsRetrofitCall
import com.example.databaseunderstanding.room.team.TeamInformationCacheMapper
import com.example.databaseunderstanding.room.team.TeamsDao
import com.google.gson.Gson

class TeamRepository
constructor(
    private val teamsRetrofitCall: TeamsRetrofitCall,
    private val teamsDao: TeamsDao,
    private val teamInformationCacheMapper: TeamInformationCacheMapper
) {
    private val TAG = "TeamRepository"

    suspend fun getTeamsInLeague(leagueId: Int, year: Int): List<TeamsInformation> {
        return try {
            var cachedTeamInformation = teamsDao.getTeams(leagueId, year)
            Log.d(TAG, "getTeamInformation: ${cachedTeamInformation.size}")
            if (cachedTeamInformation.isEmpty()) {
                val list = teamsRetrofitCall.getListOfTeamInLeague(leagueId, year)
                Log.d(TAG, "getTeamInformation: " + Gson().toJson(list))
                val teamsResponse =
                    Gson().fromJson(Gson().toJson(list), TeamsInformationResponseModel::class.java)
                Log.d(TAG, "getTeamInformation: " + Gson().toJson(teamsResponse))
                for (teamsInformation in teamsResponse.response) {
                    val entity = teamInformationCacheMapper.mapDomainToEntity(
                        teamsInformation
                    )
                    entity.year = year
                    entity.leagueID = leagueId
                    teamsDao.insertTeam(entity)
                }
                cachedTeamInformation = teamsDao.getTeams(leagueId, year)
            }
            teamInformationCacheMapper.mapEntityToModelList(cachedTeamInformation)
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }

    suspend fun getTeamDetails(teamId: Int, season: Int, league: Int): TeamStatisticsResponse {
        return try {
            val teamStatisticsResponse = teamsRetrofitCall.getTeamStatistics(teamId, season, league)
            Log.d(TAG, "getTeamDetails: " + Gson().toJson(teamStatisticsResponse))
            val teamObject = Gson().fromJson(
                Gson().toJson(
                    teamStatisticsResponse
                ),
                TeamStatisticsResponseModel::class.java
            )
            Log.d(TAG, "getTeamDetails: " + Gson().toJson(teamObject))
            TeamStatisticsResponse()
        } catch (e: Exception) {
            e.printStackTrace()
            TeamStatisticsResponse()
        }
    }

}