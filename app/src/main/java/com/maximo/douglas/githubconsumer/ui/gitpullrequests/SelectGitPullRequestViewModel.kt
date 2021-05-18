package com.maximo.douglas.githubconsumer.ui.gitpullrequests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximo.douglas.data.repository.GitPullRequestRepository
import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("UNCHECKED_CAST")
class SelectGitPullRequestViewModel(
    private val gitPullRequestRepository: GitPullRequestRepository,
    private val contextProvider: com.maximo.douglas.commons.utils.CoroutineContextProvider
) : ViewModel() {

    private val stateLiveData = MutableLiveData<SelectGitPullRequestViewModelState>()

    fun getStateLiveData(): LiveData<SelectGitPullRequestViewModelState> = stateLiveData

    private val handler = CoroutineExceptionHandler { _, exception ->
        stateLiveData.value = SelectGitPullRequestViewModelState.Error(exception)
    }

    fun getGitPullRequestList(owner: String, repository: String, page: Int) {
        stateLiveData.value = SelectGitPullRequestViewModelState.Loading
        viewModelScope.launch(handler) {
            val data = withContext(contextProvider.IO) {
                gitPullRequestRepository.getGitPullRequestList(
                    owner = owner,
                    repository = repository,
                    page = page
                )
            }

            stateLiveData.value = SelectGitPullRequestViewModelState.Success(data)
        }
    }

    sealed class SelectGitPullRequestViewModelState {

        object Loading : SelectGitPullRequestViewModelState()
        data class Error(val throwable: Throwable) : SelectGitPullRequestViewModelState()
        data class Success(val data: List<GitPullRequest>) : SelectGitPullRequestViewModelState()

    }

}