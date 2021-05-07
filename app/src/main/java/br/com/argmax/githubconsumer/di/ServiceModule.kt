package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.service.ApiDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestApiDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryApiDataSource
import org.koin.dsl.module

val serviceModule = module {
    single { ApiDataSource.createService(GitRepositoryApiDataSource::class.java) as GitRepositoryApiDataSource }
    single { ApiDataSource.createService(GitPullRequestApiDataSource::class.java) as GitPullRequestApiDataSource }
}