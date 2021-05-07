package br.com.argmax.githubconsumer

import android.app.Application
import br.com.argmax.githubconsumer.di.othersModule
import br.com.argmax.githubconsumer.di.remoteDataSourceModule
import br.com.argmax.githubconsumer.di.serviceModule
import br.com.argmax.githubconsumer.di.viewModelModule
import org.koin.core.context.startKoin

class GithubConsumerApp : Application() {

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