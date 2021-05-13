package com.maximo.douglas.githubconsumer.ui.gitrepositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximo.douglas.githubconsumer.domain.entities.gitrepository.GitRepository
import com.maximo.douglas.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import com.maximo.douglas.githubconsumer.testutils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("UNCHECKED_CAST")
class SelectGitRepositoryViewModel(
    private val gitRepositoryRemoteDataSource: GitRepositoryRemoteDataSource,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val stateLiveData = MutableLiveData<SelectGitRepositoryViewModelState>()

    fun getStateLiveData(): LiveData<SelectGitRepositoryViewModelState> = stateLiveData

    private val handler = CoroutineExceptionHandler { _, exception ->
        stateLiveData.value = SelectGitRepositoryViewModelState.Error(exception)
    }

    fun getGitRepositoryApiResponse(page: Int) {
        stateLiveData.value = SelectGitRepositoryViewModelState.Loading
        viewModelScope.launch(handler) {
            val data = withContext(contextProvider.IO) {
                gitRepositoryRemoteDataSource.getGitRepositoryList(page)
            }

            stateLiveData.value = SelectGitRepositoryViewModelState.Success(data)
        }
    }

    sealed class SelectGitRepositoryViewModelState {

        object Loading : SelectGitRepositoryViewModelState()
        data class Error(val throwable: Throwable) : SelectGitRepositoryViewModelState()
        data class Success(val data: List<GitRepository>) : SelectGitRepositoryViewModelState()

    }

}
