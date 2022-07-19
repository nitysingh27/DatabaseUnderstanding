package com.example.databaseunderstanding.room.team

import com.example.databaseunderstanding.model.teams.TeamsInformation
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class TeamInformationCacheMapper
@Inject
constructor() : EntityMapper<TeamInformationCacheEntity, TeamsInformation> {
    override fun mapEntityToDomain(entity: TeamInformationCacheEntity): TeamsInformation {
        return TeamsInformation(
            entity.team,
            entity.venue
        )
    }

    override fun mapDomainToEntity(domainModel: TeamsInformation): TeamInformationCacheEntity {
        return TeamInformationCacheEntity(
            team = domainModel.team,
            venue = domainModel.venue
        )
    }

    fun mapEntityToModelList(entityList: List<TeamInformationCacheEntity>): List<TeamsInformation> {
        return entityList.map { mapEntityToDomain(it) }
    }
}