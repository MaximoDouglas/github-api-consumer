package br.com.argmax.githubconsumer.service.gitrepository

import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository

interface GitRepositoryRemoteDataSource {

    suspend fun getGitRepositoryDtoList(
        page: Int
    ): List<GitRepository>

}