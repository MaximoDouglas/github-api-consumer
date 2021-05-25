package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel
import com.maximo.douglas.githubconsumer.ui.gitrepositories.SelectGitRepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SelectGitRepositoryViewModel(
            get(),
            get()
        )
    }
    viewModel {
        SelectGitPullRequestViewModel(
            get(),
            get()
        )
    }
}