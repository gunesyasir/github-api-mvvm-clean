package com.example.githubexplorer.presentation.logging

import android.util.Log
import com.example.githubexplorer.domain.logging.Logger
import javax.inject.Inject

class LogcatLogger @Inject constructor() : Logger {
    override fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun error(tag: String, message: String, throwable: Throwable?) {
        Log.e(tag, message, throwable)
    }
}