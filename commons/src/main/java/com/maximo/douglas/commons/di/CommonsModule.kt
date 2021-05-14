package com.maximo.douglas.commons.di

import com.maximo.douglas.commons.utils.CoroutineContextProvider
import org.koin.dsl.module

val commonsModule = module {
    single { CoroutineContextProvider() }
}