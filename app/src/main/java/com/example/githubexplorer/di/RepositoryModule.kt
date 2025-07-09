package com.example.githubexplorer.di

import com.example.githubexplorer.data.remote.api.SearchApi
import com.example.githubexplorer.data.remote.mapper.UserSearchMapper
import com.example.githubexplorer.data.remote.repository.SearchUsersRepositoryImpl
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideSearchUsersRepository(
        apiService: SearchApi,
        mapper: UserSearchMapper
    ): SearchUsersRepository {
        return SearchUsersRepositoryImpl(apiService, mapper)
    }

}