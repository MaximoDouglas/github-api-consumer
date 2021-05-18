package com.maximo.douglas.data.repository

import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestApi
import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest

interface GitPullRequestRepository {

    suspend fun getGitPullRequestList(
        owner: String,
        repository: String,
        page: Int? = 1
    ): List<GitPullRequest>

}

class GitPullRequestRepositoryImpl(
    private val mGitPullRequestApi: GitPullRequestApi
) : GitPullRequestRepository {

    override suspend fun getGitPullRequestList(owner: String, repository: String, page: Int?) =
        mGitPullRequestApi.getGitPullRequestList(
            owner = owner,
            repository = repository,
            page = page
        )

}