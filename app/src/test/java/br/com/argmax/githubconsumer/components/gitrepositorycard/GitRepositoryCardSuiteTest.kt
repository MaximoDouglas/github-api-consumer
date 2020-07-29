package br.com.argmax.githubconsumer.components.gitrepositorycard

import br.com.argmax.githubconsumer.components.gitrepositorycard.context.*
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