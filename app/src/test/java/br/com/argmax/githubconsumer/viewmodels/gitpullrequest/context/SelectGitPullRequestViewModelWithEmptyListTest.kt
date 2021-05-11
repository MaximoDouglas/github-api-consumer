package br.com.argmax.githubconsumer.viewmodels.gitpullrequest.context

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SelectGitPullRequestViewModelWithEmptyListTest : SelectGitPullRequestViewModelTest() {

    @Before
    fun `setup scenario`() {
        `when data source returns an empty GitPullRequest list`()
    }

    @Test
    fun `test if view model get a success with the given scenario`() {
        `should success when data source returns the expected data`()
    }

}