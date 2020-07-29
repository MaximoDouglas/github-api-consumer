package br.com.argmax.githubconsumer.domain.entities.pullrequest

import br.com.argmax.githubconsumer.domain.entities.user.GitUserDto
import java.io.Serializable

data class GitPullRequestDto(
    val title: String,
    val body: String,
    val html_url: String,
    val state: String,
    val user: GitUserDto
) : Serializable