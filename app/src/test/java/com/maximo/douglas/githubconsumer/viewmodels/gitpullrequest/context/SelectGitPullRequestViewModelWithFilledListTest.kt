package com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context

import com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SelectGitPullRequestViewModelWithFilledListTest : SelectGitPullRequestViewModelTest() {

    @Before
    fun `setup scenario`() {
        `when data source returns filled GitPullRequest list`()
    }

    @Test
    fun `test if view model get a success with the given scenario`() {
        `should success when data source returns the expected data`()
    }

}