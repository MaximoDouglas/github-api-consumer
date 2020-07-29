package br.com.argmax.githubconsumer.ui.di

import androidx.lifecycle.ViewModel
import br.com.argmax.githubconsumer.di.ViewModelKey
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.SelectGitPullRequestViewModel
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(SelectGitRepositoryViewModel::class)
    fun bindSelectGitRepositoryViewModel(viewModel: SelectGitRepositoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectGitPullRequestViewModel::class)
    fun bindSelectGitPullRequestViewModel(viewModel: SelectGitPullRequestViewModel): ViewModel

}