package com.maximo.douglas.domain.di

import com.maximo.douglas.domain.usecase.GetGitPullRequestUseCase
import com.maximo.douglas.domain.usecase.GetGitPullRequestUseCaseImpl
import com.maximo.douglas.domain.usecase.GetGitRepositoryUseCase
import com.maximo.douglas.domain.usecase.GetGitRepositoryUseCaseImpl
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val useCaseModule = module {
    single { GetGitRepositoryUseCaseImpl(get()) as GetGitRepositoryUseCase }
    single { GetGitPullRequestUseCaseImpl(get()) as GetGitPullRequestUseCase }
}