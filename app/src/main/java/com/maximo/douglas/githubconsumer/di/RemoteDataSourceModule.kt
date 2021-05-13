package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import com.maximo.douglas.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSourceImpl
import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val remoteDataSourceModule = module {
    single { GitRepositoryRemoteDataSourceImpl(get()) as GitRepositoryRemoteDataSource }
    single { GitPullRequestRemoteDataSourceImpl(get()) as GitPullRequestRemoteDataSource }
}