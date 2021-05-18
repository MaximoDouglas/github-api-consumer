package com.maximo.douglas.domain.usecase

import com.maximo.douglas.data.repository.GitPullRequestRepository
import com.maximo.douglas.domain.entity.gitpullrequest.GitPullRequest

interface GetGitPullRequestUseCase {

    suspend operator fun invoke(
        owner: String,
        repository: String,
        page: Int? = 1
    ): List<GitPullRequest>

}

class GetGitPullRequestUseCaseImpl(
    private val gitPullRequestRepository: GitPullRequestRepository
) : GetGitPullRequestUseCase {

    override suspend fun invoke(
        owner: String,
        repository: String,
        page: Int?
    ): List<GitPullRequest> {
        return gitPullRequestRepository.getGitPullRequestList(owner, repository, page)
    }

}
