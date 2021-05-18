package com.maximo.douglas.domain.usecase

import com.maximo.douglas.domain.entity.gitrepository.GitRepository
import com.maximo.douglas.domain.repository.GitRepositoryRepository

interface GetGitRepositoryUseCase {

    suspend operator fun invoke(page: Int): List<GitRepository>

}

class GetGitRepositoryUseCaseImpl(
    private val gitRepositoryRepository: GitRepositoryRepository
) : GetGitRepositoryUseCase {

    override suspend fun invoke(page: Int): List<GitRepository> {
        return gitRepositoryRepository.getGitRepositoryList(page)
    }

}
