package br.com.argmax.githubconsumer.viewmodels.utils.faker

import br.com.argmax.githubconsumer.domain.entities.user.GitUser

object GitUserDtoFaker {

    private val gitUserDto1 = GitUser(
        login = "CyC2018",
        avatarUrl = "https://avatars3.githubusercontent.com/u/36260787?v=4"
    )

    private val gitUserDto2 = GitUser(
        login = "alibaba",
        avatarUrl = "https://avatars1.githubusercontent.com/u/1961952?v=4"
    )

    private val gitUserDto3 = GitUser(
        login = "TC-zerol",
        avatarUrl = "https://avatars3.githubusercontent.com/u/14823155?v=4"
    )

    private val gitUserDto4 = GitUser(
        login = "ZR-Huang",
        avatarUrl = "https://avatars2.githubusercontent.com/u/25542987?v=4"
    )

    fun getGitUserDto1(): GitUser {
        return gitUserDto1
    }

    fun getGitUserDto2(): GitUser {
        return gitUserDto2
    }

    fun getGitUserDto3(): GitUser {
        return gitUserDto3
    }

    fun getGitUserDto4(): GitUser {
        return gitUserDto4
    }

}