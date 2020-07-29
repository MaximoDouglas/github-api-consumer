package br.com.argmax.githubconsumer.viewmodels

import br.com.argmax.githubconsumer.viewmodels.gitpullrequest.SelectGitPullRequestViewModelSuiteTest
import br.com.argmax.githubconsumer.viewmodels.gitrepository.SelectGitRepositoryViewModelSuiteTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    SelectGitRepositoryViewModelSuiteTest::class,
    SelectGitPullRequestViewModelSuiteTest::class
)
class ViewModelSuiteTest