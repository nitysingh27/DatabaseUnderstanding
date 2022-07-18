package com.example.databaseunderstanding.util

interface EntityMapper<Entity, DomainModel> {
    fun mapEntityToDomain(entity: Entity) : DomainModel

    fun mapDomainToEntity(domainModel: DomainModel) : Entity

}