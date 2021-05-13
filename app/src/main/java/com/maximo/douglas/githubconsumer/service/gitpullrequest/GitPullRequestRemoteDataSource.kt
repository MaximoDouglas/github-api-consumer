package com.maximo.douglas.githubconsumer.service.gitpullrequest

import com.maximo.douglas.githubconsumer.domain.entities.gitpullrequest.GitPullRequest

interface GitPullRequestRemoteDataSource {

    suspend fun getGitPullRequestList(
        owner: String,
        repository: String,
        page: Int? = 1
    ): List<GitPullRequest>

}