package br.com.argmax.githubconsumer.service.gitrepository

import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepositoryApiResponse
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