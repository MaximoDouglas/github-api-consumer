package com.maximo.douglas.features

import com.maximo.douglas.githubconsumer.features.gitpullrequests.SelectGitPullRequestFragmentTest
import com.maximo.douglas.githubconsumer.features.gitrepositories.SelectGitRepositoryFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    com.maximo.douglas.githubconsumer.features.gitrepositories.SelectGitRepositoryFragmentTest::class,
    com.maximo.douglas.githubconsumer.features.gitpullrequests.SelectGitPullRequestFragmentTest::class
)
class InstrumentedTestSuite