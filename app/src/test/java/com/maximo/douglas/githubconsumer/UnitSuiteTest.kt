package com.maximo.douglas.githubconsumer

import com.maximo.douglas.githubconsumer.components.ComponentSuiteTest
import com.maximo.douglas.githubconsumer.extensions.StringUtilsTest
import com.maximo.douglas.githubconsumer.viewmodels.ViewModelSuiteTest
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
class UnitSuiteTest