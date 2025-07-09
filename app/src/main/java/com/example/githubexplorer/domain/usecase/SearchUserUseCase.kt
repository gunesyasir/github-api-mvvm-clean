package com.example.githubexplorer.domain.usecase

import com.example.githubexplorer.core.Resource
import com.example.githubexplorer.domain.entity.UsersSearchEntity
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repository: SearchUsersRepository
) {
    suspend fun execute(query: String): Flow<Resource<UsersSearchEntity>> {
        return repository.searchUsers(query)
    }
}