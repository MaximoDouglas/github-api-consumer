package com.maximo.douglas.githubconsumer.service.gitrepository

import com.maximo.douglas.domain.entities.gitrepository.GitRepository

interface GitRepositoryRemoteDataSource {

    suspend fun getGitRepositoryList(
        page: Int
    ): List<GitRepository>

}