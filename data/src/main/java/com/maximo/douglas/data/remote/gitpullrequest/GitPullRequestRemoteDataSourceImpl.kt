package com.maximo.douglas.data.remote.gitpullrequest

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