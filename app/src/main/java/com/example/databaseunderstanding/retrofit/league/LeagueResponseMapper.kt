package com.example.databaseunderstanding.retrofit.league

import com.example.databaseunderstanding.model.leagues.LeagueResponseModel
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class LeagueResponseMapper
@Inject
constructor() : EntityMapper<LeagueResponseEntity, LeagueResponseModel> {
    override fun mapEntityToDomain(leagueResponseEntity: LeagueResponseEntity): LeagueResponseModel {
        return LeagueResponseModel(
            errors = leagueResponseEntity.errors,
            get = leagueResponseEntity.get,
            paging = leagueResponseEntity.paging,
            parameters = leagueResponseEntity.parameters,
            response = leagueResponseEntity.response,
            results = leagueResponseEntity.results
        )
    }

    override fun mapDomainToEntity(leagueResponseModel: LeagueResponseModel): LeagueResponseEntity {
        return LeagueResponseEntity(
            errors = leagueResponseModel.errors,
            get = leagueResponseModel.get,
            paging = leagueResponseModel.paging,
            parameters = leagueResponseModel.parameters,
            response = leagueResponseModel.response,
            results = leagueResponseModel.results
        )
    }

    fun mapEntityListToDomain(list: List<LeagueResponseEntity>): List<LeagueResponseModel> {
        return list.map { mapEntityToDomain(it) }
    }


}