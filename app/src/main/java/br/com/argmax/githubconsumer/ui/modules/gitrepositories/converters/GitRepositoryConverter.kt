package br.com.argmax.githubconsumer.ui.modules.gitrepositories.converters

import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto

object GitRepositoryConverter {

    fun convertDtoListToCardDtoList(gitRepositoryDtoList: List<GitRepositoryDto>): List<GitRepositoryCardDto> {
        val gitRepositoryCardDtoList = mutableListOf<GitRepositoryCardDto>()

        gitRepositoryDtoList.forEach { gitRepositoryDto ->
            gitRepositoryCardDtoList.add(
                GitRepositoryCardDto(
                    gitRepositoryName = gitRepositoryDto.name,
                    gitRepositoryDescription = gitRepositoryDto.description,
                    forkQuantity = gitRepositoryDto.forks_count.toString(),
                    starsQuantity = gitRepositoryDto.stargazers_count.toString(),
                    userImageUrl = gitRepositoryDto.owner.avatar_url,
                    userName = gitRepositoryDto.owner.login
                )
            )
        }

        return gitRepositoryCardDtoList
    }

}