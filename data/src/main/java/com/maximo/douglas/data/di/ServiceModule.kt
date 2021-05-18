package com.maximo.douglas.data.di

import com.maximo.douglas.commons.utils.ApiDataSource.Companion.createService
import com.maximo.douglas.data.BuildConfig.BASE_URL
import com.maximo.douglas.data.remote.GitPullRequestApi
import com.maximo.douglas.data.remote.GitRepositoryApi
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val serviceModule = module {
    single { createService(BASE_URL, GitRepositoryApi::class.java) as GitRepositoryApi }
    single { createService(BASE_URL, GitPullRequestApi::class.java) as GitPullRequestApi }
}