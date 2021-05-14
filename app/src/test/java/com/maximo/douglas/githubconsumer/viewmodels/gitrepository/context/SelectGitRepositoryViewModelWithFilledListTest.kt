package com.maximo.douglas.githubconsumer.viewmodels.gitrepository.context

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SelectGitRepositoryViewModelWithFilledListTest : SelectGitRepositoryViewModelTest() {

    @Before
    fun `setup scenario`() {
        `when data source returns filled GitRepository list`()
    }

    @Test
    fun `test if view model get a success with the given scenario`() {
        `should success when data source returns the expected data`()
    }

}