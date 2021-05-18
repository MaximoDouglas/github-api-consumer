package com.maximo.douglas.data.di

import com.maximo.douglas.data.remote.ApiDataSource.Companion.createService
import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestApi
import com.maximo.douglas.data.remote.gitrepository.GitRepositoryApi
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val serviceModule = module {
    single { createService(GitRepositoryApi::class.java) as GitRepositoryApi }
    single { createService(GitPullRequestApi::class.java) as GitPullRequestApi }
}