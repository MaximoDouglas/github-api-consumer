package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.commons.utils.CoroutineContextProvider
import org.koin.dsl.module

val othersModule = module {
    single { CoroutineContextProvider() }
}