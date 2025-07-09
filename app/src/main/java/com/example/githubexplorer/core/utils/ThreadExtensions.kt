package com.example.githubexplorer.core.utils

import android.os.Looper

private val Thread.isMain: Boolean
    get() = Looper.getMainLooper().thread == Thread.currentThread()

fun isMainThread() = Thread.currentThread().isMain