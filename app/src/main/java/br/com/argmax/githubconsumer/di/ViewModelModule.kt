package br.com.argmax.githubconsumer.di

import br.com.argmax.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel
import br.com.argmax.githubconsumer.ui.gitrepositories.SelectGitRepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SelectGitRepositoryViewModel(get(), get()) }
    viewModel { SelectGitPullRequestViewModel(get(), get()) }
}