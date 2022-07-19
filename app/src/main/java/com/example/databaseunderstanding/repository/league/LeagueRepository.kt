package com.example.databaseunderstanding.repository.league

import android.util.Log
import com.example.databaseunderstanding.model.leagues.LeagueResponse
import com.example.databaseunderstanding.model.leagues.LeagueResponseModel
import com.example.databaseunderstanding.retrofit.league.LeagueResponseEntity
import com.example.databaseunderstanding.retrofit.league.LeagueResponseMapper
import com.example.databaseunderstanding.retrofit.league.LeagueRetrofitCall
import com.example.databaseunderstanding.room.league.LeagueCacheMapper
import com.example.databaseunderstanding.room.league.LeagueDao
import com.google.gson.Gson

class LeagueRepository
constructor(
    private val leagueRetrofitCall: LeagueRetrofitCall,
    private val leagueResponseMapper: LeagueResponseMapper,
    private val leagueCacheMapper: LeagueCacheMapper,
    private val leagueDao: LeagueDao
) {
    private val TAG = "LeagueRepository"

    suspend fun getLeagues(): List<LeagueResponse> {
       return  try {
            var cachedData = leagueDao.getLeague()
            Log.v(TAG, "${cachedData.size}")
            if (cachedData.isEmpty()) {
                Log.v(TAG, "Making network call ")
                val networkFixtures = leagueRetrofitCall.getLeagueDetails()
//                Log.v(TAG, Gson().toJson(networkFixtures))
                val net =
                    Gson().fromJson(
                        Gson().toJson(networkFixtures),
                        LeagueResponseEntity::class.java
                    )
                for (league in net.response) {
                    leagueDao.insertLeague(leagueCacheMapper.mapDomainToEntity(league))
                }
                cachedData = leagueDao.getLeague()
            }
             leagueCacheMapper.mapListEntityToDomain(cachedData)
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }
}