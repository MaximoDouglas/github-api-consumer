package br.com.argmax.githubconsumer

import br.com.argmax.githubconsumer.modules.NavigationTest
import br.com.argmax.githubconsumer.modules.gitpullrequests.SelectGitPullRequestFragmentTest
import br.com.argmax.githubconsumer.modules.gitrepositories.SelectGitRepositoryFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    NavigationTest::class,
    SelectGitRepositoryFragmentTest::class,
    SelectGitPullRequestFragmentTest::class
)
class UISuiteTest