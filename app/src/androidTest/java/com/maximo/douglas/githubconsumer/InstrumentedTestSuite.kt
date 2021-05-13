package com.maximo.douglas.githubconsumer

import com.maximo.douglas.githubconsumer.activities.MainActivityTest
import com.maximo.douglas.githubconsumer.features.gitpullrequests.SelectGitPullRequestFragmentTest
import com.maximo.douglas.githubconsumer.features.gitrepositories.SelectGitRepositoryFragmentTest
import com.maximo.douglas.githubconsumer.navigation.NavigationTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    NavigationTest::class,
    SelectGitRepositoryFragmentTest::class,
    SelectGitPullRequestFragmentTest::class
)
class InstrumentedTestSuite