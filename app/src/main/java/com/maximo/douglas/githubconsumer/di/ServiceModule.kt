package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.githubconsumer.service.ApiDataSource
import com.maximo.douglas.githubconsumer.service.gitpullrequest.GitPullRequestApiDataSource
import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryApiDataSource
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val serviceModule = module {
    single { ApiDataSource.createService(GitRepositoryApiDataSource::class.java) as GitRepositoryApiDataSource }
    single { ApiDataSource.createService(GitPullRequestApiDataSource::class.java) as GitPullRequestApiDataSource }
}