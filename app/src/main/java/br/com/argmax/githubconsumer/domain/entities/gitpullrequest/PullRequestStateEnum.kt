package br.com.argmax.githubconsumer.domain.entities.gitpullrequest

enum class PullRequestStateEnum(val value: String) {
    OPEN("open"),
    CLOSED("closed")
}