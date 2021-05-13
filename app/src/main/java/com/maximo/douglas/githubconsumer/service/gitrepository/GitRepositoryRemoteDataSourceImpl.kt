package com.maximo.douglas.githubconsumer.service.gitrepository

import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryApiDataSource
import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource

class GitRepositoryRemoteDataSourceImpl(
    private val mGitRepositoryApiDataSource: GitRepositoryApiDataSource
) : GitRepositoryRemoteDataSource {

    override suspend fun getGitRepositoryList(page: Int) =
        mGitRepositoryApiDataSource.getGitRepositoryApiResponse(page = page).items

}