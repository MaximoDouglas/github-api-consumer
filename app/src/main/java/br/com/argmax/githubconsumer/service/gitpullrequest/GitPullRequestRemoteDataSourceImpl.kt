package br.com.argmax.githubconsumer.service.gitpullrequest

import javax.inject.Inject

class GitPullRequestRemoteDataSourceImpl @Inject constructor(
    private val mGitPullRequestApiDataSource: GitPullRequestApiDataSource
) : GitPullRequestRemoteDataSource {

    override suspend fun getGitPullRequestDtoList(owner: String, repository: String, page: Int?) =
        mGitPullRequestApiDataSource.getGitPullRequestDtoList(
            owner = owner,
            repository = repository,
            page = page
        )

}