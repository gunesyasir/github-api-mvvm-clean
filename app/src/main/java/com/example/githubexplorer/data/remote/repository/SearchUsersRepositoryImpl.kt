package com.example.githubexplorer.data.remote.repository

import com.example.githubexplorer.data.remote.api.SearchApi
import com.example.githubexplorer.data.remote.model.UsersSearchResponse
import com.example.githubexplorer.data.remote.toResult
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import javax.inject.Inject

class SearchUsersRepositoryImpl @Inject constructor(
    private val api: SearchApi
) : SearchUsersRepository {

    override suspend fun searchUsers(query: String): Result<UsersSearchResponse?> {
        val response = api.searchUsers(query)
        return response.toResult()
    }

}

