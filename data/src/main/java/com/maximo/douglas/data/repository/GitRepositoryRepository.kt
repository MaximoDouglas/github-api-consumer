package com.maximo.douglas.data.repository

import com.maximo.douglas.data.remote.gitrepository.GitRepositoryApi
import com.maximo.douglas.domain.entity.gitrepository.GitRepository

interface GitRepositoryRepository {

    suspend fun getGitRepositoryList(
        page: Int
    ): List<GitRepository>

}

class GitRepositoryRepositoryImpl(
    private val mGitRepositoryApi: GitRepositoryApi
) : GitRepositoryRepository {

    override suspend fun getGitRepositoryList(page: Int): List<GitRepository> {
        return mGitRepositoryApi.getGitRepositoryApiResponse(page = page).items
    }

}