package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.service.ApiDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestApiDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSourceImpl
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryApiDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSourceImpl

abstract class RemoteDataSourceModule {
//
//    @Singleton
//    @Binds
//    abstract fun provideGitRepositoryRemoteDataSource(
//        remoteDataSource: GitRepositoryRemoteDataSourceImpl
//    ): GitRepositoryRemoteDataSource
//
//    @Singleton
//    @Binds
//    abstract fun provideGitPullRequestRemoteDataSource(
//        remoteDataSource: GitPullRequestRemoteDataSourceImpl
//    ): GitPullRequestRemoteDataSource

}


object ApiDataSourceModule {

//    @Provides
//    @Singleton
//    fun provideGitRepositoryApiDataSource(): GitRepositoryApiDataSource {
//        return ApiDataSource.createService(GitRepositoryApiDataSource::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideGitPullRequestApiDataSource(): GitPullRequestApiDataSource {
//        return ApiDataSource.createService(GitPullRequestApiDataSource::class.java)
//    }

}