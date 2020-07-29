package br.com.argmax.githubconsumer.viewmodels.gitpullrequest

import br.com.argmax.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelErrorTest
import br.com.argmax.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelWithEmptyListTest
import br.com.argmax.githubconsumer.viewmodels.gitpullrequest.context.SelectGitPullRequestViewModelWithFilledListTest
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