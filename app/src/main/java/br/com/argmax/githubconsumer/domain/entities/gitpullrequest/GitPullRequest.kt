package br.com.argmax.githubconsumer.domain.entities.gitpullrequest

import br.com.argmax.githubconsumer.domain.entities.user.GitUser
import br.com.argmax.githubconsumer.utils.StringUtils
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GitPullRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String?,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("state")
    val state: String? = PullRequestStateEnum.OPEN.value,
    @SerializedName("user")
    val user: GitUser
) : Serializable {

    fun shortGitPullRequestBody(): String? {
        return StringUtils.compactStringWithDots(body, 60)
    }

}