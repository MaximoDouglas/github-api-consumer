package br.com.argmax.githubconsumer.service.gitpullrequest

import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto

interface GitPullRequestRemoteDataSource {

    suspend fun getGitPullRequestDtoList(
        owner: String,
        repository: String,
        page: Int? = 1
    ): List<GitPullRequestDto>

}