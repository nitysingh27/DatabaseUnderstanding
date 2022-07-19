package com.example.databaseunderstanding.room.league

import com.example.databaseunderstanding.model.leagues.LeagueResponse
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class LeagueCacheMapper
@Inject
constructor() : EntityMapper<LeagueResponseCacheEntity, LeagueResponse> {
    override fun mapEntityToDomain(entity: LeagueResponseCacheEntity): LeagueResponse {
        return LeagueResponse(
            country = entity.country,
            league = entity.league,
            seasons = entity.seasons
        )
    }

    override fun mapDomainToEntity(domainModel: LeagueResponse): LeagueResponseCacheEntity {
        return LeagueResponseCacheEntity(
            country = domainModel.country,
            league = domainModel.league,
            seasons = domainModel.seasons
        )
    }

    fun mapListEntityToDomain(list: List<LeagueResponseCacheEntity>): List<LeagueResponse> {
        return list.map { mapEntityToDomain(it) }
    }

}