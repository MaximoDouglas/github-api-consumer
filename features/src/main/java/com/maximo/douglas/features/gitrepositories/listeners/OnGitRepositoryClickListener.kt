package com.maximo.douglas.features.gitrepositories.listeners

interface OnGitRepositoryClickListener {

    fun onClick(ownerLogin: String, repositoryName: String)

}