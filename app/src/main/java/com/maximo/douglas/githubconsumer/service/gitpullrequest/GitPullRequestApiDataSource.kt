package com.maximo.douglas.githubconsumer.service.gitpullrequest

import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitPullRequestApiDataSource {

    @GET("repos/{owner}/{repository}/pulls")
    suspend fun getGitPullRequestList(
        @Path("owner") owner: String,
        @Path("repository") repository: String,
        @Query("page") page: Int? = 1,
        @Query("state") state: String? = "all"
    ): List<GitPullRequest>

}