package br.com.argmax.githubconsumer

import android.app.Application
import br.com.argmax.githubconsumer.di.ApplicationComponent
import br.com.argmax.githubconsumer.di.DaggerApplicationComponent

class GithubConsumerApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

}