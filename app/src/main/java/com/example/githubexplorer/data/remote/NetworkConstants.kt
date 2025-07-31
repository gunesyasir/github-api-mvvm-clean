package com.example.githubexplorer.data.remote

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

object NetworkConstants {
    val MEDIA_TYPE_JSON: MediaType = "application/json".toMediaType()
}

object NetworkErrors {
    const val NULL_BODY = "Response body is null"
}
