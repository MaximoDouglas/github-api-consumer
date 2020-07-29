package br.com.argmax.githubconsumer.viewmodels.utils.faker

import br.com.argmax.githubconsumer.domain.entities.user.GitUserDto

object GitUserDtoFaker {

    private val gitUserDto1 = GitUserDto(
        login = "CyC2018",
        avatar_url = "https://avatars3.githubusercontent.com/u/36260787?v=4"
    )

    private val gitUserDto2 = GitUserDto(
        login = "alibaba",
        avatar_url = "https://avatars1.githubusercontent.com/u/1961952?v=4"
    )

    private val gitUserDto3 = GitUserDto(
        login = "TC-zerol",
        avatar_url = "https://avatars3.githubusercontent.com/u/14823155?v=4"
    )

    private val gitUserDto4 = GitUserDto(
        login = "ZR-Huang",
        avatar_url = "https://avatars2.githubusercontent.com/u/25542987?v=4"
    )

    fun getGitUserDto1(): GitUserDto {
        return gitUserDto1
    }

    fun getGitUserDto2(): GitUserDto {
        return gitUserDto2
    }

    fun getGitUserDto3(): GitUserDto {
        return gitUserDto3
    }

    fun getGitUserDto4(): GitUserDto {
        return gitUserDto4
    }

}