package com.example.databaseunderstanding.repository.fixtures

import android.util.Log
import com.example.databaseunderstanding.model.fixture.FixtureItem
import com.example.databaseunderstanding.retrofit.fixture.FixtrueRetrofitCall
import com.example.databaseunderstanding.retrofit.fixture.FixtureResponseEntity
import com.example.databaseunderstanding.retrofit.fixture.FixtureMapper
import com.example.databaseunderstanding.room.fixture.FixtureCacheMapper
import com.example.databaseunderstanding.room.fixture.FixtureDao
import com.google.gson.Gson

class FixtureRepository
constructor(
    private val fixtureDao: FixtureDao,
    private val fixtureRetrofit: FixtrueRetrofitCall,
    private val cacheMapper: FixtureCacheMapper,
    private val networkMapper: FixtureMapper
) {

    suspend fun getFixtures(date : String): List<FixtureItem> {
        return try {
            var cachedData = fixtureDao.getFixtures(date)
            Log.v("Repository","${cachedData.size}")
            if(cachedData.isEmpty()) {
                Log.v("Repository","Making network call ")
                val networkFixtures = fixtureRetrofit.getListOfFixtures(date)
                Log.v("Repository", networkFixtures.toString())
                val net =
                    Gson().fromJson(networkFixtures.toString(), FixtureResponseEntity::class.java)
                val fixtureResponse = networkMapper.mapEntityToDomain(net)
                val responseList = fixtureResponse.response
                for (fixture in responseList) {
                    val fixtureResponseCacheEntity = cacheMapper.mapDomainToEntity(fixture)
                    fixtureResponseCacheEntity.date = date
                    fixtureDao.insertFixture(fixtureResponseCacheEntity)
                }
                cachedData = fixtureDao.getFixtures(date)
                Log.v("Repository","Making network call ${cachedData.size}")
            }
            cacheMapper.mapListOfEntityToDomain(cachedData)
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }
}