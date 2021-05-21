package com.maximo.douglas.features

import com.maximo.douglas.features.gitpullrequests.SelectGitPullRequestFragmentTest
import com.maximo.douglas.features.gitrepositories.SelectGitRepositoryFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SelectGitRepositoryFragmentTest::class,
    SelectGitPullRequestFragmentTest::class
)
class InstrumentedTestSuite