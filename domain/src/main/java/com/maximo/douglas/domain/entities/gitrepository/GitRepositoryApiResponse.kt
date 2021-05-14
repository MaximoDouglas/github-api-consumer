package com.maximo.douglas.domain.entities.gitrepository

import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepository>
) : Serializable