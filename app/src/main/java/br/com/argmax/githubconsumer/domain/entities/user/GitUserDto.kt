package br.com.argmax.githubconsumer.domain.entities.user

import java.io.Serializable

data class GitUserDto(
    val avatar_url: String,
    val login: String
) : Serializable