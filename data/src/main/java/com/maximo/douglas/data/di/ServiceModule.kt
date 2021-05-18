package com.maximo.douglas.data.di

import com.maximo.douglas.data.remote.ApiDataSource.Companion.createService
import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestApiDataSource
import com.maximo.douglas.data.remote.gitrepository.GitRepositoryApiDataSource
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val serviceModule = module {
    single { createService(GitRepositoryApiDataSource::class.java) as GitRepositoryApiDataSource }
    single { createService(GitPullRequestApiDataSource::class.java) as GitPullRequestApiDataSource }
}