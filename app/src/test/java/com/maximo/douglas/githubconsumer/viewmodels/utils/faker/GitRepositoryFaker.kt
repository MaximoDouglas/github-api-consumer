package com.maximo.douglas.githubconsumer.viewmodels.utils.faker

import com.maximo.douglas.domain.entities.gitrepository.GitRepository

object GitRepositoryFaker {

    private val gitRepository1 = GitRepository(
        name = "CS-Notes",
        owner = GitUserFaker.getGitUser1(),
        description = ":books: 技术面试必备基础知识、Leetcode、计算机操作系统、计算机网络、系统设计、Java、Python、C++",
        forksCount = 34734,
        stargazersCount = 106549
    )

    private val gitRepository2 = GitRepository(
        name = "fastjson",
        owner = GitUserFaker.getGitUser2(),
        description = "A fast JSON parser/generator for Java.  ",
        forksCount = 5862,
        stargazersCount = 22022
    )

    fun getList(): List<GitRepository> {
        return listOf(
            gitRepository1,
            gitRepository2
        )
    }

}