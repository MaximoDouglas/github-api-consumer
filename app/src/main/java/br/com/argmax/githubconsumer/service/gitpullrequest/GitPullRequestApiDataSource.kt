package br.com.argmax.githubconsumer.service.gitpullrequest

import br.com.argmax.githubconsumer.domain.entities.gitpullrequest.GitPullRequest
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitPullRequestApiDataSource {

    @GET("repos/{owner}/{repository}/pulls")
    suspend fun getGitPullRequestDtoList(
        @Path("owner") owner: String,
        @Path("repository") repository: String,
        @Query("page") page: Int? = 1,
        @Query("state") state: String? = "all"
    ): List<GitPullRequest>

}