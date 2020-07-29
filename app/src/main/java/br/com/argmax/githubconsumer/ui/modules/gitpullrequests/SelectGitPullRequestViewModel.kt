package br.com.argmax.githubconsumer.ui.modules.gitpullrequests

import androidx.lifecycle.*
import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class SelectGitPullRequestViewModel @Inject constructor(
    private val gitPullRequestRemoteDataSource: GitPullRequestRemoteDataSource,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val stateLiveData = MutableLiveData<SelectGitPullRequestViewModelState>()

    fun getStateLiveData(): LiveData<SelectGitPullRequestViewModelState> = stateLiveData

    private val handler = CoroutineExceptionHandler { _, exception ->
        stateLiveData.value = SelectGitPullRequestViewModelState.Error(exception)
    }

    fun getGitPullRequestDtoList(owner: String, repository: String, page: Int) {
        stateLiveData.value = SelectGitPullRequestViewModelState.Loading
        viewModelScope.launch(handler) {
            val data = withContext(contextProvider.IO) {
                gitPullRequestRemoteDataSource.getGitPullRequestDtoList(
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
        data class Success(val data: List<GitPullRequestDto>) : SelectGitPullRequestViewModelState()

    }

}