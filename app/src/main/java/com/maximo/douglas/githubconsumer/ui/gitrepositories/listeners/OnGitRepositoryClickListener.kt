package com.maximo.douglas.githubconsumer.ui.gitrepositories.listeners

interface OnGitRepositoryClickListener {

    fun onClick(ownerLogin: String, repositoryName: String)

}