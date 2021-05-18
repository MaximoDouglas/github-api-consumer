package com.maximo.douglas.domain.repository

import com.maximo.douglas.domain.entity.gitpullrequest.GitPullRequest

interface GitPullRequestRepository {

    suspend fun getGitPullRequestList(
        owner: String,
        repository: String,
        page: Int?
    ): List<GitPullRequest>

}