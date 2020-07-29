package br.com.argmax.githubconsumer.viewmodels.utils.faker

import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto

object GitRepositoryDtoFaker {

    private val gitRepository1 = GitRepositoryDto(
        name = "CS-Notes",
        owner = GitUserDtoFaker.getGitUserDto1(),
        description = ":books: 技术面试必备基础知识、Leetcode、计算机操作系统、计算机网络、系统设计、Java、Python、C++",
        forks_count = 34734,
        stargazers_count = 106549
    )

    private val gitRepository2 = GitRepositoryDto(
        name = "fastjson",
        owner = GitUserDtoFaker.getGitUserDto2(),
        description = "A fast JSON parser/generator for Java.  ",
        forks_count = 5862,
        stargazers_count = 22022
    )

    fun getList(): List<GitRepositoryDto> {
        return listOf(
            gitRepository1,
            gitRepository2
        )
    }

}