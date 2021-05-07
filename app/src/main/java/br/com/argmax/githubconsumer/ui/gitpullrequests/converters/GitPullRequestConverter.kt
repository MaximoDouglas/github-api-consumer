package br.com.argmax.githubconsumer.ui.gitpullrequests.converters

import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto
import br.com.argmax.githubconsumer.domain.entities.pullrequest.PullRequestStateEnum
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto

object GitPullRequestConverter {

    fun convertDtoListToCardDtoList(gitPullRequestDtoList: List<GitPullRequestDto>): Pair<List<GitPullRequestCardDto>, Pair<Int, Int>> {
        var openPullRequestQuantity = 0
        var closedPullRequestQuantity = 0

        val gitPullRequestCardDtoList = mutableListOf<GitPullRequestCardDto>()

        gitPullRequestDtoList.forEach { gitPullRequestDto ->
            if (gitPullRequestDto.state == PullRequestStateEnum.OPEN.value) {
                openPullRequestQuantity++
            } else {
                closedPullRequestQuantity++
            }

            gitPullRequestCardDtoList.add(
                GitPullRequestCardDto(
                    gitPullRequestTitle = gitPullRequestDto.title,
                    gitPullRequestBody = gitPullRequestDto.body,
                    gitPullRequestUrl = gitPullRequestDto.html_url,
                    userName = gitPullRequestDto.user.login,
                    userImageUrl = gitPullRequestDto.user.avatar_url
                )
            )
        }

        return Pair(gitPullRequestCardDtoList, Pair(openPullRequestQuantity, closedPullRequestQuantity))
    }

}