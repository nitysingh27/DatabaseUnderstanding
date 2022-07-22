package com.example.databaseunderstanding.repository.team

import android.content.Context
import android.util.Log
import com.example.databaseunderstanding.model.teams.TeamStatisticsResponse
import com.example.databaseunderstanding.model.teams.TeamStatisticsResponseModel
import com.example.databaseunderstanding.model.teams.TeamsInformation
import com.example.databaseunderstanding.model.teams.TeamsInformationResponseModel
import com.example.databaseunderstanding.retrofit.teams.TeamsRetrofitCall
import com.example.databaseunderstanding.room.team.TeamInformationCacheMapper
import com.example.databaseunderstanding.room.team.TeamsDao
import com.google.gson.Gson
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import java.util.*

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

    suspend fun getTeamDetails(
        teamId: Int,
        season: Int,
        league: Int,
        context: Context
    ): TeamStatisticsResponse {
        return try {
            val teamStatisticsResponse =
                teamsRetrofitCall.getTeamStatistics(teamId, season, league)
//                JSONObject(loadJSONFromAsset("fixtures.json", context))
            Log.d(TAG, "getTeamDetails: " + Gson().toJson(teamStatisticsResponse))
            val teamObject = Gson().fromJson(
                Gson().toJson(teamStatisticsResponse),
                TeamStatisticsResponseModel::class.java
            )
            Log.d(TAG, "getTeamDetails: " + Gson().toJson(teamObject))
            TeamStatisticsResponse()
        } catch (e: Exception) {
            e.printStackTrace()
            TeamStatisticsResponse()
        }
    }

    fun loadJSONFromAsset(name: String?, context: Context): String {
        var json: String? = null
        val obj: JSONObject? = null
        try {
            val am = context.assets
            val mapList =
                Arrays.asList(*am.list(""))
            if (mapList != null && mapList.size > 0 && mapList.contains(name)) {
                if (context != null) {
                    val `is` = context.assets.open(name!!)
                    if (`is` != null) {
                        val size = `is`.available()
                        val buffer = ByteArray(size)
                        `is`.read(buffer)
                        `is`.close()
                        json = String(buffer, StandardCharsets.UTF_8)
                    }
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return ""
        }
        return json.toString()
    }

    val resp =
        "{\"get\":\"teams/statistics\",\"parameters\":{\"league\":\"61\",\"team\":\"0\",\"season\":\"2021\"},\"errors\":[],\"results\":11,\"paging\":{\"current\":1,\"total\":1},\"response\":{\"league\":{\"id\":61,\"name\":\"Ligue 1\",\"country\":\"France\",\"logo\":\"https://media.api-sports.io/football/leagues/61.png\",\"flag\":\"https://media.api-sports.io/flags/fr.svg\",\"season\":2021},\"team\":{\"id\":null,\"name\":null,\"logo\":null},\"form\":null,\"fixtures\":{\"played\":{\"home\":0,\"away\":0,\"total\":0},\"wins\":{\"home\":0,\"away\":0,\"total\":0},\"draws\":{\"home\":0,\"away\":0,\"total\":0},\"loses\":{\"home\":0,\"away\":0,\"total\":0}},\"goals\":{\"for\":{\"total\":{\"home\":0,\"away\":0,\"total\":0},\"average\":{\"home\":\"0.0\",\"away\":\"0.0\",\"total\":\"0.0\"},\"minute\":{\"0-15\":{\"total\":null,\"percentage\":null},\"16-30\":{\"total\":null,\"percentage\":null},\"31-45\":{\"total\":null,\"percentage\":null},\"46-60\":{\"total\":null,\"percentage\":null},\"61-75\":{\"total\":null,\"percentage\":null},\"76-90\":{\"total\":null,\"percentage\":null},\"91-105\":{\"total\":null,\"percentage\":null},\"106-120\":{\"total\":null,\"percentage\":null}}},\"against\":{\"total\":{\"home\":0,\"away\":0,\"total\":0},\"average\":{\"home\":\"0.0\",\"away\":\"0.0\",\"total\":\"0.0\"},\"minute\":{\"0-15\":{\"total\":null,\"percentage\":null},\"16-30\":{\"total\":null,\"percentage\":null},\"31-45\":{\"total\":null,\"percentage\":null},\"46-60\":{\"total\":null,\"percentage\":null},\"61-75\":{\"total\":null,\"percentage\":null},\"76-90\":{\"total\":null,\"percentage\":null},\"91-105\":{\"total\":null,\"percentage\":null},\"106-120\":{\"total\":null,\"percentage\":null}}}},\"biggest\":{\"streak\":{\"wins\":0,\"draws\":0,\"loses\":0},\"wins\":{\"home\":null,\"away\":null},\"loses\":{\"home\":null,\"away\":null},\"goals\":{\"for\":{\"home\":0,\"away\":0},\"against\":{\"home\":0,\"away\":0}}},\"clean_sheet\":{\"home\":0,\"away\":0,\"total\":0},\"failed_to_score\":{\"home\":0,\"away\":0,\"total\":0},\"penalty\":{\"scored\":{\"total\":0,\"percentage\":\"0%\"},\"missed\":{\"total\":0,\"percentage\":\"0%\"},\"total\":0},\"lineups\":[],\"cards\":{\"yellow\":{\"0-15\":{\"total\":null,\"percentage\":null},\"16-30\":{\"total\":null,\"percentage\":null},\"31-45\":{\"total\":null,\"percentage\":null},\"46-60\":{\"total\":null,\"percentage\":null},\"61-75\":{\"total\":null,\"percentage\":null},\"76-90\":{\"total\":null,\"percentage\":null},\"91-105\":{\"total\":null,\"percentage\":null},\"106-120\":{\"total\":null,\"percentage\":null}},\"red\":{\"0-15\":{\"total\":null,\"percentage\":null},\"16-30\":{\"total\":null,\"percentage\":null},\"31-45\":{\"total\":null,\"percentage\":null},\"46-60\":{\"total\":null,\"percentage\":null},\"61-75\":{\"total\":null,\"percentage\":null},\"76-90\":{\"total\":null,\"percentage\":null},\"91-105\":{\"total\":null,\"percentage\":null},\"106-120\":{\"total\":null,\"percentage\":null}}}}}"
}