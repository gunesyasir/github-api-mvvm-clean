package com.example.githubexplorer.presentation.searchuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubexplorer.core.Resource
import com.example.githubexplorer.domain.entity.UserEntity
import com.example.githubexplorer.domain.usecase.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(private val searchUsersUseCase: SearchUsersUseCase) :
    ViewModel() {

    private val _userSearchState = MutableStateFlow(UserSearchState())
    val userSearchState: StateFlow<UserSearchState>
        get() = _userSearchState.asStateFlow()

    fun onSearchTextChanged(query: String) {
        if (query.isNotBlank()) {
            viewModelScope.launch {
                searchUsersUseCase.execute(query)
                    .onStart {}
                    .collect {
                        when (it) {
                            is Resource.Loading -> {
                                _userSearchState.value =
                                    UserSearchState(
                                        isLoading = true,
                                        data = _userSearchState.value.data,
                                        error = null
                                    )
                            }

                            is Resource.Success -> {
                                _userSearchState.value =
                                    UserSearchState(isLoading = false, data = it.data, error = null)
                            }

                            is Resource.Error -> {
                                _userSearchState.value = UserSearchState(
                                    isLoading = false,
                                    data = _userSearchState.value.data, // error will not be shown user if have data on screen
                                    error = it.exception.message ?: "Error"
                                )
                            }
                        }
                    }
            }
        }
    }

    fun onUserClicked(user: UserEntity) {
        println("hello $user")
    }
}