package com.example.githubexplorer.domain.entity

data class UsersSearchEntity(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val users: List<UserEntity>
)