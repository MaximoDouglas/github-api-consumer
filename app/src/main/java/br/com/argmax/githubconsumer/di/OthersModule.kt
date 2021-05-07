package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.utils.CoroutineContextProvider
import org.koin.dsl.module

val othersModule = module {
    single { CoroutineContextProvider() }
}