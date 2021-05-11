package br.com.argmax.githubconsumer.viewmodels.utils.faker

import br.com.argmax.githubconsumer.domain.entities.gitpullrequest.GitPullRequest
import br.com.argmax.githubconsumer.viewmodels.utils.faker.GitUserDtoFaker.getGitUserDto3
import br.com.argmax.githubconsumer.viewmodels.utils.faker.GitUserDtoFaker.getGitUserDto4

object GitPullRequestDtoFaker {

    private val gitPullRequestDto1 = GitPullRequest(
        title = "fixed (修改剑指offer35，47，目录问题)",
        body = "剑指offer 35题\r\n返回链表除头节点为clone节点外，其余节点为原节点。" +
                "\r\n\r\n剑指offer 47题\r\n逻辑错误\r\n\r\n剑指offer 43题\r\n目录错误，无法链接",
        htmlUrl = "https://github.com/CyC2018/CS-Notes/pull/957",
        state = "open",
        user = getGitUserDto3()
    )

    private val gitPullRequestDto2 = GitPullRequest(
        title = "Update on \"攻击技术.md\" and \"HTTP.md\"",
        body = "- 新增关于XSS的分类及对应原理\r\n- 新增XSS的一种防范方法\r\n- 新增拒绝服务攻击的分类\r\n- " +
                "新增拒绝服务攻击可能的防御方法\r\n- 新增502状态码解释",
        htmlUrl = "https://github.com/CyC2018/CS-Notes/pull/956",
        state = "open",
        user = getGitUserDto4()
    )

    fun getList(): List<GitPullRequest> {
        return listOf(
            gitPullRequestDto1,
            gitPullRequestDto2
        )
    }

}
