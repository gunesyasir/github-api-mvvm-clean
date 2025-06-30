package com.example.githubexplorer.presentation.searchuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubexplorer.domain.usecase.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(private val searchUsersUseCase: SearchUsersUseCase) :
    ViewModel() {

    fun onSearchTextChanged(query: String) {
        if (query.isNotBlank()) {
            viewModelScope.launch {
                searchUsersUseCase(query)
            }
        }
    }
}