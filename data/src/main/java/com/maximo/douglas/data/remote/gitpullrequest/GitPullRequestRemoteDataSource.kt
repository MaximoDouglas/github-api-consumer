package com.maximo.douglas.data.remote.gitpullrequest

import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest

interface GitPullRequestRemoteDataSource {

    suspend fun getGitPullRequestList(
        owner: String,
        repository: String,
        page: Int? = 1
    ): List<GitPullRequest>

}