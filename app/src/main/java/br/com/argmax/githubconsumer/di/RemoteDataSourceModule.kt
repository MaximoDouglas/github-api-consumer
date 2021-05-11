package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSourceImpl
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl
import org.koin.dsl.module

@Suppress("USELESS_CAST")
val remoteDataSourceModule = module {
    single { GitRepositoryRemoteDataSourceImpl(get()) as GitRepositoryRemoteDataSource }
    single { GitPullRequestRemoteDataSourceImpl(get()) as GitPullRequestRemoteDataSource }
}