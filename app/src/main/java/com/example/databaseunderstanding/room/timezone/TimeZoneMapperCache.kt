package com.example.databaseunderstanding.room.timezone

import com.example.databaseunderstanding.model.TimeZone
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class TimeZoneMapperCache
@Inject
constructor() : EntityMapper<TimeZoneCacheEntity, TimeZone> {
    override fun mapEntityToDomain(timeZoneCacheEntity: TimeZoneCacheEntity): TimeZone {
        return TimeZone(
            response = timeZoneCacheEntity.timeZone
        )
    }

    override fun mapDomainToEntity(timeZone: TimeZone): TimeZoneCacheEntity {
        return TimeZoneCacheEntity(
            timeZone = timeZone.response
        )
    }

    fun mapListOfEntityToDomain(list: List<TimeZoneCacheEntity>): List<TimeZone> {
        return list.map { mapEntityToDomain(it) }
    }

}