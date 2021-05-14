package com.maximo.douglas.githubconsumer.viewmodels.gitrepository

import com.maximo.douglas.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelErrorTest
import com.maximo.douglas.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelWithEmptyListTest
import com.maximo.douglas.githubconsumer.viewmodels.gitrepository.context.SelectGitRepositoryViewModelWithFilledListTest
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