package com.example.githubexplorer.presentation.utils

import android.widget.ImageView
import coil3.load
import coil3.request.ImageRequest
import coil3.request.transformations
import coil3.transform.CircleCropTransformation

fun ImageView.loadCircularImage(
    url: String,
    builder: ImageRequest.Builder.() -> Unit = {}
) {
    this.load(url) {
        transformations(CircleCropTransformation())
        builder()
    }
}
