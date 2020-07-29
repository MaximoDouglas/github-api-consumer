package br.com.argmax.githubconsumer.domain.entities.pullrequest

enum class PullRequestStateEnum(val value: String) {
    OPEN("open"),
    CLOSED("closed")
}