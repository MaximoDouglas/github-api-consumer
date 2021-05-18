package com.maximo.douglas.data.repositoryimpl

import com.maximo.douglas.data.remote.GitPullRequestApi
import com.maximo.douglas.domain.repository.GitPullRequestRepository

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