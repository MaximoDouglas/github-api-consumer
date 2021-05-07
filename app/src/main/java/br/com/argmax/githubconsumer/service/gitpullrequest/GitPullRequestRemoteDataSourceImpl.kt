package br.com.argmax.githubconsumer.service.gitpullrequest

class GitPullRequestRemoteDataSourceImpl(
    private val mGitPullRequestApiDataSource: GitPullRequestApiDataSource
) : GitPullRequestRemoteDataSource {

    override suspend fun getGitPullRequestDtoList(owner: String, repository: String, page: Int?) =
        mGitPullRequestApiDataSource.getGitPullRequestDtoList(
            owner = owner,
            repository = repository,
            page = page
        )

}