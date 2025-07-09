package com.example.githubexplorer.data.remote.repository

import com.example.githubexplorer.core.Resource
import com.example.githubexplorer.data.remote.api.SearchApi
import com.example.githubexplorer.data.remote.mapper.UserSearchMapper
import com.example.githubexplorer.domain.entity.UsersSearchEntity
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchUsersRepositoryImpl @Inject constructor(
    private val api: SearchApi,
    private val mapper: UserSearchMapper,
) : SearchUsersRepository {

    override suspend fun searchUsers(query: String): Flow<Resource<UsersSearchEntity>> = flow {
        emit(Resource.Loading)
        try {
            val response = api.searchUsers(query)
            val entity = mapper.run { response.toEntity() }
            emit(Resource.Success(entity))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)

}

