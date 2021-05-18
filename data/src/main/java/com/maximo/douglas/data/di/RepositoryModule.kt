package com.maximo.douglas.data.di

import com.maximo.douglas.data.repositoryimpl.GitPullRequestRepositoryImpl
import com.maximo.douglas.data.repositoryimpl.GitRepositoryRepositoryImpl
import com.maximo.douglas.domain.repository.GitPullRequestRepository
import com.maximo.douglas.domain.repository.GitRepositoryRepository
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val repositoryModule = module {
    single { GitRepositoryRepositoryImpl(get()) as GitRepositoryRepository }
    single { GitPullRequestRepositoryImpl(get()) as GitPullRequestRepository }
}