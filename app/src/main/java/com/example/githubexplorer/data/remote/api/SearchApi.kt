package com.example.githubexplorer.data.remote.api

import com.example.githubexplorer.data.remote.model.UsersSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): Response<UsersSearchResponse>
}