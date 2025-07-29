package com.example.githubexplorer.di

import com.example.githubexplorer.data.remote.repository.SearchUsersRepositoryImpl
import com.example.githubexplorer.domain.repository.SearchUsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUsersRepository(
        impl: SearchUsersRepositoryImpl
    ): SearchUsersRepository

}