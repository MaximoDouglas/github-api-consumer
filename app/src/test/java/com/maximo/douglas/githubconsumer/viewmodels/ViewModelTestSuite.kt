package com.maximo.douglas.githubconsumer.viewmodels

import com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.SelectGitPullRequestViewModelSuiteTest
import com.maximo.douglas.githubconsumer.viewmodels.gitrepository.SelectGitRepositoryViewModelSuiteTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    SelectGitRepositoryViewModelSuiteTest::class,
    SelectGitPullRequestViewModelSuiteTest::class
)
class ViewModelTestSuite