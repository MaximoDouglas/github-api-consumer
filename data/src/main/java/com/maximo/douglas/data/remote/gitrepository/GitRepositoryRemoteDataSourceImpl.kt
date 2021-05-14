package com.maximo.douglas.data.remote.gitrepository

class GitRepositoryRemoteDataSourceImpl(
    private val mGitRepositoryApiDataSource: GitRepositoryApiDataSource
) : GitRepositoryRemoteDataSource {

    override suspend fun getGitRepositoryList(page: Int) =
        mGitRepositoryApiDataSource.getGitRepositoryApiResponse(page = page).items

}