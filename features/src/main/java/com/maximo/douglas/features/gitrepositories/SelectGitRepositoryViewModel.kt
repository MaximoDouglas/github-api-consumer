package com.maximo.douglas.features.gitrepositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maximo.douglas.commons.utils.CoroutineContextProvider
import com.maximo.douglas.domain.entity.gitrepository.GitRepository
import com.maximo.douglas.domain.usecase.GetGitRepositoryUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("UNCHECKED_CAST")
class SelectGitRepositoryViewModel(
    private val getGitRepositoryUseCase: GetGitRepositoryUseCase,
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
                getGitRepositoryUseCase.invoke(page)
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
