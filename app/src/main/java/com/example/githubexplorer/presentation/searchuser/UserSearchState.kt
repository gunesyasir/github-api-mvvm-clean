package com.example.githubexplorer.presentation.searchuser

import com.example.githubexplorer.domain.entity.UsersSearchEntity

data class UserSearchState(
    val isLoading: Boolean = false,
    val data: UsersSearchEntity? = null,
    val error: String? = null
)
