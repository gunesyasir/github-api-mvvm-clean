package com.example.githubexplorer.presentation.logging

import coil3.EventListener
import coil3.request.*
import com.example.githubexplorer.domain.logging.Logger
import javax.inject.Inject

class CoilLogger @Inject constructor(
    private val logger: Logger
) : EventListener() {

    companion object {
        private const val TAG = "CoilLogger"
    }

    override fun onSuccess(request: ImageRequest, result: SuccessResult) {
        logger.debug(
            TAG, """
            ✅ Success loading image
            • URL: ${request.data}
            • Data Source: ${result.dataSource}
        """.trimIndent()
        )
    }

    override fun onError(request: ImageRequest, result: ErrorResult) {
        logger.error(
            TAG, """
            ❌ Error loading image
            • URL: ${request.data}
            • Throwable: ${result.throwable}
        """.trimIndent()
        )
    }
}

