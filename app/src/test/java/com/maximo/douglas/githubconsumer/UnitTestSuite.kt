package com.maximo.douglas.githubconsumer

import com.maximo.douglas.githubconsumer.components.ComponentTestSuite
import com.maximo.douglas.githubconsumer.viewmodels.ViewModelTestSuite
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@ExperimentalCoroutinesApi
@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComponentTestSuite::class,
    ViewModelTestSuite::class
)
class UnitTestSuite