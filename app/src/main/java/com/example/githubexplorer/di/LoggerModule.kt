package com.example.githubexplorer.di

import com.example.githubexplorer.domain.logging.Logger
import com.example.githubexplorer.presentation.logging.LogcatLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {

    @Binds
    @Singleton
    abstract fun bindLogger(impl: LogcatLogger): Logger

}