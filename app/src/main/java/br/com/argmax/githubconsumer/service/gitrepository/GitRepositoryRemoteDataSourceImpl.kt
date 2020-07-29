package br.com.argmax.githubconsumer.service.gitrepository

import javax.inject.Inject

class GitRepositoryRemoteDataSourceImpl @Inject constructor(
    private val mGitRepositoryApiDataSource: GitRepositoryApiDataSource
) : GitRepositoryRemoteDataSource {

    override suspend fun getGitRepositoryDtoList(page: Int) =
        mGitRepositoryApiDataSource.getGitRepositoryApiResponse(page = page).items

}