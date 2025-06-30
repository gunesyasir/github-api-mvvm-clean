package com.example.githubexplorer.data.remote

import retrofit2.HttpException
import retrofit2.Response

fun <T> Response<T>.toResult(): Result<T> {
    return if (isSuccessful) {
        body()?.let { Result.success(it) }
            ?: Result.failure(NullPointerException(NetworkErrors.NULL_BODY))
    } else {
        Result.failure(HttpException(this))
    }
}