package com.maximo.douglas.githubconsumer.service.gitrepository

import com.maximo.douglas.domain.entities.gitrepository.GitRepositoryApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoryApiDataSource {

    @GET("search/repositories")
    suspend fun getGitRepositoryApiResponse(
        @Query("q") q: String? = "language:Java",
        @Query("sort") sort: String? = "stars",
        @Query("page") page: Int
    ): GitRepositoryApiResponse

}