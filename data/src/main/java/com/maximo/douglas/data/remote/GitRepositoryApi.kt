package com.maximo.douglas.data.remote

import com.maximo.douglas.data.model.GitRepositoryApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoryApi {

    @GET("search/repositories")
    suspend fun getGitRepositoryApiResponse(
        @Query("q") q: String? = "language:Java",
        @Query("sort") sort: String? = "stars",
        @Query("page") page: Int
    ): GitRepositoryApiResponse

}