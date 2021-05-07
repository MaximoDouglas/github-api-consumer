package br.com.argmax.githubconsumer.ui.gitrepositories.listeners

interface OnGitRepositoryClickListener {

    fun onClick(ownerLogin: String, repositoryName: String)

}