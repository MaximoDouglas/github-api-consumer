package com.maximo.douglas.data.di

import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestRemoteDataSource
import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestRemoteDataSourceImpl
import com.maximo.douglas.data.remote.gitrepository.GitRepositoryRemoteDataSource
import com.maximo.douglas.data.remote.gitrepository.GitRepositoryRemoteDataSourceImpl
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val remoteDataSourceModule = module {
    single { GitRepositoryRemoteDataSourceImpl(get()) as GitRepositoryRemoteDataSource }
    single { GitPullRequestRemoteDataSourceImpl(get()) as GitPullRequestRemoteDataSource }
}