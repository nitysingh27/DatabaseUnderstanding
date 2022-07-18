package com.example.databaseunderstanding.retrofit.timezone

import com.example.databaseunderstanding.model.TimeZone
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class TimeZoneMapper
@Inject
constructor() : EntityMapper<TimeZoneNetworkEntity, TimeZone> {
    override fun mapEntityToDomain(timeZoneNetworkEntity: TimeZoneNetworkEntity): TimeZone {
        return TimeZone(
            errors = timeZoneNetworkEntity.errors,
            get = timeZoneNetworkEntity.get,
            paging = timeZoneNetworkEntity.paging,
            parameters = timeZoneNetworkEntity.parameters,
            response = timeZoneNetworkEntity.response,
            results = timeZoneNetworkEntity.results
        )
    }

    override fun mapDomainToEntity(timeZone: TimeZone): TimeZoneNetworkEntity {
        return TimeZoneNetworkEntity(
            errors = timeZone.errors,
            get = timeZone.get,
            paging = timeZone.paging,
            parameters = timeZone.parameters,
            response = timeZone.response,
            results = timeZone.results
        )
    }

    fun mapEntityListToDomain(list: List<TimeZoneNetworkEntity>): List<TimeZone> {
        return list.map { mapEntityToDomain(it) }
    }


}