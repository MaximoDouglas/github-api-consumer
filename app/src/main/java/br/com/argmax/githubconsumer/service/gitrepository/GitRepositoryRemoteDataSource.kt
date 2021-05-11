package br.com.argmax.githubconsumer.service.gitrepository

import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository

interface GitRepositoryRemoteDataSource {

    suspend fun getGitRepositoryList(
        page: Int
    ): List<GitRepository>

}