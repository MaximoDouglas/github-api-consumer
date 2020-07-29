package br.com.argmax.githubconsumer.viewmodels.gitrepository

import br.com.argmax.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelErrorTest
import br.com.argmax.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelWithEmptyListTest
import br.com.argmax.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelWithFilledListTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    SelectGitRepositoryViewModelWithEmptyListTest::class,
    SelectGitRepositoryViewModelWithFilledListTest::class,
    SelectGitRepositoryViewModelErrorTest::class
)
class SelectGitRepositoryViewModelSuiteTest