package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.githubconsumer.testutils.CoroutineContextProvider
import org.koin.dsl.module

val othersModule = module {
    single { CoroutineContextProvider() }
}