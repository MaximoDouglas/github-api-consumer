package br.com.argmax.githubconsumer.ui.di

import br.com.argmax.githubconsumer.MainActivity
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.SelectGitPullRequestFragment
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: SelectGitRepositoryFragment)
    fun inject(fragment: SelectGitPullRequestFragment)

}