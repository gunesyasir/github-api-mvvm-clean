package com.example.githubexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class UsersSearchResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<User>,
)
