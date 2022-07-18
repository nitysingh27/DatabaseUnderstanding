package com.example.databaseunderstanding.repository.timeZone

import android.util.Log
import com.example.databaseunderstanding.model.TimeZone
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneMapper
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneNetworkEntity
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneRetrofitCall
import com.example.databaseunderstanding.room.timezone.TimeZoneDao
import com.example.databaseunderstanding.room.timezone.TimeZoneMapperCache
import com.google.gson.Gson

class TimeZoneRepository(
    private val timeZoneRetrofitCall: TimeZoneRetrofitCall,
    private val timeZoneMapper: TimeZoneMapper,
    private val timeZoneDao: TimeZoneDao,
    private val timeZoneMapperCache: TimeZoneMapperCache
) {
    private val TAG = "TimeZoneRepository"
    suspend fun getTimeZones(): List<TimeZone> {
       return  try {
            var cachedData = timeZoneDao.getTimeZones()
            Log.v(TAG,"${cachedData.size}")
            if(cachedData.isEmpty()) {
                Log.v(TAG,"Making network call ")
                val networkTimezones = timeZoneRetrofitCall.getTimeZones()
                Log.v(TAG, networkTimezones.toString())
                val net =
                    Gson().fromJson(networkTimezones.toString(), TimeZoneNetworkEntity::class.java)
                val timeZoneResponse = timeZoneMapper.mapEntityToDomain(net)
                timeZoneDao.insertTimeZones(timeZoneMapperCache.mapDomainToEntity(timeZoneResponse))
                cachedData = timeZoneDao.getTimeZones()
                Log.v(TAG,"Making network call ${cachedData.size}")
            }
            timeZoneMapperCache.mapListOfEntityToDomain(cachedData)
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }


}