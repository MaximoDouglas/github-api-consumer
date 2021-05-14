package com.maximo.douglas.githubconsumer.viewmodels.utils.faker

import com.maximo.douglas.domain.entities.user.GitUser

object GitUserFaker {

    private val gitUser1 = GitUser(
        login = "CyC2018",
        avatarUrl = "https://avatars3.githubusercontent.com/u/36260787?v=4"
    )

    private val gitUser2 = GitUser(
        login = "alibaba",
        avatarUrl = "https://avatars1.githubusercontent.com/u/1961952?v=4"
    )

    private val gitUser3 = GitUser(
        login = "TC-zerol",
        avatarUrl = "https://avatars3.githubusercontent.com/u/14823155?v=4"
    )

    private val gitUser4 = GitUser(
        login = "ZR-Huang",
        avatarUrl = "https://avatars2.githubusercontent.com/u/25542987?v=4"
    )

    fun getGitUser1(): GitUser {
        return gitUser1
    }

    fun getGitUser2(): GitUser {
        return gitUser2
    }

    fun getGitUser3(): GitUser {
        return gitUser3
    }

    fun getGitUser4(): GitUser {
        return gitUser4
    }

}