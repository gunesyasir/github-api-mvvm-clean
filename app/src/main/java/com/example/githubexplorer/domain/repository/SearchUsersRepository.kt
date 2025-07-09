package com.example.githubexplorer.domain.repository

import com.example.githubexplorer.core.Resource
import com.example.githubexplorer.domain.entity.UsersSearchEntity
import kotlinx.coroutines.flow.Flow

interface SearchUsersRepository {
    suspend fun searchUsers(query: String): Flow<Resource<UsersSearchEntity>>
}
