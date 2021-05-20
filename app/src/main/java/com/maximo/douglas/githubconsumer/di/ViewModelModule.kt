package com.maximo.douglas.githubconsumer.di

import com.maximo.douglas.features.gitpullrequests.SelectGitPullRequestViewModel
import com.maximo.douglas.features.gitrepositories.SelectGitRepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        com.maximo.douglas.features.gitrepositories.SelectGitRepositoryViewModel(
            get(),
            get()
        )
    }
    viewModel {
        com.maximo.douglas.features.gitpullrequests.SelectGitPullRequestViewModel(
            get(),
            get()
        )
    }
}