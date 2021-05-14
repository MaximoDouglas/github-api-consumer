package com.maximo.douglas.githubconsumer.components

import com.maximo.douglas.githubconsumer.components.gitpullrequestcard.GitPullRequestCardSuiteTest
import com.maximo.douglas.githubconsumer.components.gitrepositorycard.GitRepositoryCardSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GitRepositoryCardSuiteTest::class,
    GitPullRequestCardSuiteTest::class
)
class ComponentTestSuite