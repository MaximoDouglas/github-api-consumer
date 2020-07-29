package br.com.argmax.githubconsumer.service.gitrepository

import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto

interface GitRepositoryRemoteDataSource {

    suspend fun getGitRepositoryDtoList(
        page: Int
    ): List<GitRepositoryDto>

}