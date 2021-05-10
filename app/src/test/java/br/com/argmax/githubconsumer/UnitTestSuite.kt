package br.com.argmax.githubconsumer

import br.com.argmax.githubconsumer.components.ComponentSuiteTest
import br.com.argmax.githubconsumer.utilitary.StringUtilsTest
import br.com.argmax.githubconsumer.viewmodels.ViewModelSuiteTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComponentSuiteTest::class,
    ViewModelSuiteTest::class,
    StringUtilsTest::class
)
class UnitTestSuite