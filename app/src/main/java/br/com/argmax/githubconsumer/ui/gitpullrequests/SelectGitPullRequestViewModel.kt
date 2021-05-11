package br.com.argmax.githubconsumer.ui.gitpullrequests

import androidx.lifecycle.*
import br.com.argmax.githubconsumer.domain.entities.gitpullrequest.GitPullRequest
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("UNCHECKED_CAST")
class SelectGitPullRequestViewModel(
    private val gitPullRequestRemoteDataSource: GitPullRequestRemoteDataSource,
    private val contextProvider: CoroutineContextProvider
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
                gitPullRequestRemoteDataSource.getGitPullRequestList(
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