package br.com.argmax.githubconsumer.domain.entities.gitrepository

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepository>
) : Serializable