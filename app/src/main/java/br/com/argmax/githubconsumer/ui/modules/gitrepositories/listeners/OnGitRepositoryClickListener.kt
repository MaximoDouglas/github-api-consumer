package br.com.argmax.githubconsumer.ui.modules.gitrepositories.listeners

interface OnGitRepositoryClickListener {

    fun onClick(ownerLogin: String, repositoryName: String)

}