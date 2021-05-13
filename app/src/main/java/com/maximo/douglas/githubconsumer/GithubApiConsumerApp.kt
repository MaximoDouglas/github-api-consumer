package com.maximo.douglas.githubconsumer

import android.app.Application
import com.maximo.douglas.githubconsumer.di.othersModule
import com.maximo.douglas.githubconsumer.di.remoteDataSourceModule
import com.maximo.douglas.githubconsumer.di.serviceModule
import com.maximo.douglas.githubconsumer.di.viewModelModule
import org.koin.core.context.startKoin

class GithubApiConsumerApp : Application() {

    override fun onCreate() {
        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    remoteDataSourceModule,
                    othersModule,
                    serviceModule
                )
            )
        }
        super.onCreate()
    }

}