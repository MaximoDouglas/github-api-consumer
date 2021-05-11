package br.com.argmax.githubconsumer.domain.entities.gitrepository

import br.com.argmax.githubconsumer.domain.entities.user.GitUser
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GitRepository(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("owner")
    val owner: GitUser
) : Serializable