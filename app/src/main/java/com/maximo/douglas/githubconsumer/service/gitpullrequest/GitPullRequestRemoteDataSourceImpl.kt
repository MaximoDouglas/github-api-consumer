package com.maximo.douglas.githubconsumer.service.gitpullrequest

import com.maximo.douglas.githubconsumer.service.gitpullrequest.GitPullRequestApiDataSource
import com.maximo.douglas.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource

class GitPullRequestRemoteDataSourceImpl(
    private val mGitPullRequestApiDataSource: GitPullRequestApiDataSource
) : GitPullRequestRemoteDataSource {

    override suspend fun getGitPullRequestList(owner: String, repository: String, page: Int?) =
        mGitPullRequestApiDataSource.getGitPullRequestList(
            owner = owner,
            repository = repository,
            page = page
        )

}