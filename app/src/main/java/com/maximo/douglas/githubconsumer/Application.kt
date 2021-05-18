package com.maximo.douglas.githubconsumer

import android.app.Application
import com.maximo.douglas.commons.di.commonsModule
import com.maximo.douglas.data.di.remoteDataSourceModule
import com.maximo.douglas.data.di.serviceModule
import com.maximo.douglas.githubconsumer.di.viewModelModule
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    remoteDataSourceModule,
                    commonsModule,
                    serviceModule
                )
            )
        }
        super.onCreate()
    }

}