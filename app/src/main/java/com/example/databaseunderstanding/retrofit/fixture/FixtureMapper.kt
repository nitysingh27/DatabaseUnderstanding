package com.example.databaseunderstanding.retrofit.fixture

import com.example.databaseunderstanding.model.FixtureNetworkModel
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class FixtureMapper
@Inject
constructor() : EntityMapper<FixtureResponseEntity, FixtureNetworkModel> {
    override fun mapEntityToDomain(fixtureResponseEntity: FixtureResponseEntity): FixtureNetworkModel {
        return FixtureNetworkModel(
            errors = fixtureResponseEntity.errors,
            get = fixtureResponseEntity.get,
            paging = fixtureResponseEntity.paging,
            parameters = fixtureResponseEntity.parameters,
            response = fixtureResponseEntity.response,
            results = fixtureResponseEntity.results
        )
    }

    override fun mapDomainToEntity(fixturesResponse: FixtureNetworkModel): FixtureResponseEntity {
        return FixtureResponseEntity(
            errors = fixturesResponse.errors,
            get = fixturesResponse.get,
            paging = fixturesResponse.paging,
            parameters = fixturesResponse.parameters,
            response = fixturesResponse.response,
            results = fixturesResponse.results
        )
    }

    fun mapEntityListToDomain(list: List<FixtureResponseEntity>): List<FixtureNetworkModel> {
        return list.map { mapEntityToDomain(it) }
    }


}