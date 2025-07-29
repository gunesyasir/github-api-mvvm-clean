package com.example.githubexplorer

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import com.example.githubexplorer.presentation.image.CoilImageLoader
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application(), SingletonImageLoader.Factory {

    @Inject
    lateinit var coilImageLoader: CoilImageLoader

    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return coilImageLoader.newImageLoader(context)
    }

}