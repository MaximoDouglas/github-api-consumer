package com.maximo.douglas.data.repositoryimpl

import com.maximo.douglas.data.remote.GitRepositoryApi
import com.maximo.douglas.domain.entity.gitrepository.GitRepository
import com.maximo.douglas.domain.repository.GitRepositoryRepository

class GitRepositoryRepositoryImpl(
    private val mGitRepositoryApi: GitRepositoryApi
) : GitRepositoryRepository {

    override suspend fun getGitRepositoryList(page: Int): List<GitRepository> {
        return mGitRepositoryApi.getGitRepositoryApiResponse(page = page).items
    }

}