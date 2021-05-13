package com.maximo.douglas.githubconsumer.domain.entities.gitrepository

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepository>
) : Serializable