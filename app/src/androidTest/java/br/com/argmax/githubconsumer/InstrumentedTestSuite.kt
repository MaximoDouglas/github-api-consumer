package br.com.argmax.githubconsumer

import br.com.argmax.githubconsumer.activities.MainActivityTest
import br.com.argmax.githubconsumer.navigation.NavigationTest
import br.com.argmax.githubconsumer.fragments.gitpullrequests.SelectGitPullRequestFragmentTest
import br.com.argmax.githubconsumer.fragments.gitrepositories.SelectGitRepositoryFragmentTest
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