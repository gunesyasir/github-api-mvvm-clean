package com.example.githubexplorer.presentation.image

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import com.example.githubexplorer.domain.logging.Logger
import com.example.githubexplorer.presentation.logging.CoilLogger
import javax.inject.Inject


class CoilImageLoader @Inject constructor(
    private val logger: Logger
) : SingletonImageLoader.Factory {
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader.Builder(context)
            .eventListener(CoilLogger(logger))
            .build()
    }
}