package br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos

import br.com.argmax.githubconsumer.utils.StringUtils.compactStringWithDots

class GitPullRequestCardDto(
    val gitPullRequestTitle: String,
    private val gitPullRequestBody: String?,
    val gitPullRequestUrl: String,
    val userImageUrl: String,
    val userName: String
) {

    fun getGitPullRequestBody(): String? {
        return compactStringWithDots(gitPullRequestBody, 60)
    }

}