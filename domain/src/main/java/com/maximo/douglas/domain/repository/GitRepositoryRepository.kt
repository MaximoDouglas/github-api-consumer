package com.maximo.douglas.domain.repository

import com.maximo.douglas.domain.entity.gitrepository.GitRepository

interface GitRepositoryRepository {

    suspend fun getGitRepositoryList(
        page: Int
    ): List<GitRepository>

}