package br.com.argmax.githubconsumer.components

import br.com.argmax.githubconsumer.components.gitpullrequestcard.GitPullRequestCardSuiteTest
import br.com.argmax.githubconsumer.components.gitrepositorycard.GitRepositoryCardSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GitRepositoryCardSuiteTest::class,
    GitPullRequestCardSuiteTest::class
)
class ComponentSuiteTest