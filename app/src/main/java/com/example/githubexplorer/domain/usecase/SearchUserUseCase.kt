package com.example.githubexplorer.domain.usecase

import com.example.githubexplorer.data.remote.model.UsersSearchResponse
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repository: SearchUsersRepository
) {
    suspend operator fun invoke(query: String): Result<UsersSearchResponse?> {
        return repository.searchUsers(query)
    }
}