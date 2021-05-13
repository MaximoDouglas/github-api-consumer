package com.maximo.douglas.githubconsumer.domain.entities.gitrepository

import com.maximo.douglas.githubconsumer.domain.entities.user.GitUser
import com.maximo.douglas.githubconsumer.testutils.StringUtils.compactStringWithDots
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
) : Serializable {

    fun gitRepositoryShortDescription(): String? {
        return compactStringWithDots(description, 60)
    }

}