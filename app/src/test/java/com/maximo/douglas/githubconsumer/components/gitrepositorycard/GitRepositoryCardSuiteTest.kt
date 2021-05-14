package com.maximo.douglas.githubconsumer.components.gitrepositorycard

import com.maximo.douglas.githubconsumer.components.gitrepositorycard.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GitRepositoryCardRepositoryNameTest::class,
    GitRepositoryCardRepositoryDescriptionTest::class,
    GitRepositoryCardRepositoryNullDescriptionTest::class,
    GitRepositoryCardRepositoryStarsTest::class,
    GitRepositoryCardRepositoryForksTest::class,
    GitRepositoryCardUserImageTest::class,
    GitRepositoryCardUserNameTest::class
)
class GitRepositoryCardSuiteTest