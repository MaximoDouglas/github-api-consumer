package br.com.argmax.githubconsumer.domain.entities.repository

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepositoryDto>
) : Serializable