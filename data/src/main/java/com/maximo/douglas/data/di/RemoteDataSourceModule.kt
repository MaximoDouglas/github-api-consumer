package com.maximo.douglas.data.di

import com.maximo.douglas.data.repository.GitPullRequestRepository
import com.maximo.douglas.data.repository.GitPullRequestRepositoryImpl
import com.maximo.douglas.data.repository.GitRepositoryRepository
import com.maximo.douglas.data.repository.GitRepositoryRepositoryImpl
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val remoteDataSourceModule = module {
    single { GitRepositoryRepositoryImpl(get()) as GitRepositoryRepository }
    single { GitPullRequestRepositoryImpl(get()) as GitPullRequestRepository }
}