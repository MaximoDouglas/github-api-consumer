package br.com.argmax.githubconsumer.ui.components.repositorycard.dto

import br.com.argmax.githubconsumer.utils.StringUtils.compactStringWithDots

class GitRepositoryCardDto(
    val gitRepositoryName: String,
    private val gitRepositoryDescription: String?,
    val forkQuantity: String,
    val starsQuantity: String,
    val userImageUrl: String,
    val userName: String
) {

    fun getGitRepositoryDescription(): String? {
        return compactStringWithDots(gitRepositoryDescription, 60)
    }

}