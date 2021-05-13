package com.maximo.douglas.githubconsumer.components.gitpullrequestcard.context

import org.junit.Before
import org.junit.Test

class GitPullRequestCardWithoutBodyTest : GitPullRequestCardTest() {

    @Before
    fun `setup scenario`() {
        `when pull request card has no body`()
    }

    @Test
    fun `test if pull request body is gone`() {
        `assert that pull request body is gone`()
    }

    @Test
    fun `test if pull request body is null or empty`() {
        `assert that pull request body is null or empty`()
    }

}