package br.com.argmax.githubconsumer.ui.gitpullrequests.converters

import br.com.argmax.githubconsumer.domain.entities.gitpullrequest.GitPullRequest
import br.com.argmax.githubconsumer.domain.entities.gitpullrequest.PullRequestStateEnum
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto

object GitPullRequestConverter {

    fun convertDtoListToCardDtoList(gitPullRequestList: List<GitPullRequest>): Pair<List<GitPullRequestCardDto>, Pair<Int, Int>> {
        var openPullRequestQuantity = 0
        var closedPullRequestQuantity = 0

        val gitPullRequestCardDtoList = mutableListOf<GitPullRequestCardDto>()

        gitPullRequestList.forEach { gitPullRequestDto ->
            if (gitPullRequestDto.state == PullRequestStateEnum.OPEN.value) {
                openPullRequestQuantity++
            } else {
                closedPullRequestQuantity++
            }

            gitPullRequestCardDtoList.add(
                GitPullRequestCardDto(
                    gitPullRequestTitle = gitPullRequestDto.title,
                    gitPullRequestBody = gitPullRequestDto.body,
                    gitPullRequestUrl = gitPullRequestDto.htmlUrl,
                    userName = gitPullRequestDto.user.login,
                    userImageUrl = gitPullRequestDto.user.avatarUrl
                )
            )
        }

        return Pair(gitPullRequestCardDtoList, Pair(openPullRequestQuantity, closedPullRequestQuantity))
    }

}