package br.com.argmax.githubconsumer.viewmodels.utils.faker

import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository

object GitRepositoryDtoFaker {

    private val gitRepository1 = GitRepository(
        name = "CS-Notes",
        owner = GitUserDtoFaker.getGitUserDto1(),
        description = ":books: 技术面试必备基础知识、Leetcode、计算机操作系统、计算机网络、系统设计、Java、Python、C++",
        forksCount = 34734,
        stargazersCount = 106549
    )

    private val gitRepository2 = GitRepository(
        name = "fastjson",
        owner = GitUserDtoFaker.getGitUserDto2(),
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