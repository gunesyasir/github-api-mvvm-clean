package com.example.githubexplorer.domain.repository

import com.example.githubexplorer.data.remote.model.UsersSearchResponse

interface SearchUsersRepository {
    suspend fun searchUsers(query: String): Result<UsersSearchResponse?>
}
