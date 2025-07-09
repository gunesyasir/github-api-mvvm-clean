package com.example.githubexplorer.data.remote.mapper

interface Mapper<Model, Entity> {

    fun Model.toEntity(): Entity

    fun Entity.toModel(): Model

    fun List<Model>?.mapToEntityList(): List<Entity> {
        return this?.map { it.toEntity() } ?: emptyList()
    }

    fun List<Entity>?.mapToModelList(): List<Model> {
        return this?.map { it.toModel() } ?: emptyList()
    }
}