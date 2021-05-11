package br.com.argmax.githubconsumer.ui.gitrepositories.converters

import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto

object GitRepositoryConverter {

    fun convertDtoListToCardDtoList(gitRepositoryList: List<GitRepository>): List<GitRepositoryCardDto> {
        val gitRepositoryCardDtoList = mutableListOf<GitRepositoryCardDto>()

        gitRepositoryList.forEach { gitRepositoryDto ->
            gitRepositoryCardDtoList.add(
                GitRepositoryCardDto(
                    gitRepositoryName = gitRepositoryDto.name,
                    gitRepositoryDescription = gitRepositoryDto.description,
                    forkQuantity = gitRepositoryDto.forksCount.toString(),
                    starsQuantity = gitRepositoryDto.stargazersCount.toString(),
                    userImageUrl = gitRepositoryDto.owner.avatarUrl,
                    userName = gitRepositoryDto.owner.login
                )
            )
        }

        return gitRepositoryCardDtoList
    }

}