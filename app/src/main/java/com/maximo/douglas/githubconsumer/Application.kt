package com.maximo.douglas.githubconsumer

import android.app.Application
import com.maximo.douglas.commons.di.commonsModule
import com.maximo.douglas.data.di.repositoryModule
import com.maximo.douglas.data.di.serviceModule
import com.maximo.douglas.domain.di.useCaseModule
import com.maximo.douglas.githubconsumer.di.viewModelModule
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        startKoin {
            modules(
                listOf(
                    commonsModule,
                    serviceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
        super.onCreate()
    }

}