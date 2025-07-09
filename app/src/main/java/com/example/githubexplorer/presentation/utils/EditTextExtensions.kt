package com.example.githubexplorer.presentation.utils

import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.githubexplorer.core.utils.isMainThread
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun EditText.textChanges(): Flow<CharSequence?> {
    return callbackFlow {
        if (!isMainThread()) {
            throw IllegalStateException("EditText.textChanges() must be called on the main thread.")
        }

        val listener = doOnTextChanged { text, _, _, _ -> trySend(text) }
        awaitClose { removeTextChangedListener(listener) }
    }
}