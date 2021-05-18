package com.maximo.douglas.data.model

import com.maximo.douglas.domain.entity.gitrepository.GitRepository
import java.io.Serializable

data class GitRepositoryApiResponse(
    val items: List<GitRepository>
) : Serializable