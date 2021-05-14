package com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest

import com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelErrorTest
import com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelWithEmptyListTest
import com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelWithFilledListTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    SelectGitPullRequestViewModelErrorTest::class,
    SelectGitPullRequestViewModelWithEmptyListTest::class,
    SelectGitPullRequestViewModelWithFilledListTest::class
)
class SelectGitPullRequestViewModelSuiteTest