package br.com.argmax.githubconsumer.di

import android.content.Context
import br.com.argmax.githubconsumer.ui.di.MainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [RemoteDataSourceModule::class, ApiDataSourceModule::class, ViewModelBuilderModule::class, SubcomponentsModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory

}

@Module(subcomponents = [MainComponent::class])
object SubcomponentsModule