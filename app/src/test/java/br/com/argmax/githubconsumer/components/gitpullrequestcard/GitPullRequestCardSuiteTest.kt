package br.com.argmax.githubconsumer.components.gitpullrequestcard

import br.com.argmax.githubconsumer.components.gitpullrequestcard.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GitPullRequestCardTitleTest::class,
    GitPullRequestCardWithBodyTest::class,
    GitPullRequestCardWithoutBodyTest::class,
    GitPullRequestCardUserImageTest::class,
    GitPullRequestCardUserNameTest::class
)
class GitPullRequestCardSuiteTest