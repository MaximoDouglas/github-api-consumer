package com.maximo.douglas.githubconsumer.viewmodels.gitrepository.context

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.maximo.douglas.domain.entities.gitrepository.GitRepository
import com.maximo.douglas.githubconsumer.ui.gitrepositories.SelectGitRepositoryViewModel
import com.maximo.douglas.githubconsumer.ui.gitrepositories.SelectGitRepositoryViewModel.SelectGitRepositoryViewModelState
import com.maximo.douglas.githubconsumer.viewmodels.utils.TestContextProvider
import com.maximo.douglas.githubconsumer.viewmodels.utils.TestCoroutineRule
import com.maximo.douglas.githubconsumer.viewmodels.utils.faker.GitRepositoryFaker
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
open class SelectGitRepositoryViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mGitRepositoryRemoteDataSource: com.maximo.douglas.data.remote.gitrepository.GitRepositoryRemoteDataSource

    @Mock
    private lateinit var mViewStateObserver: Observer<SelectGitRepositoryViewModelState>

    private lateinit var mSelectRepositoryViewModel: SelectGitRepositoryViewModel

    private var mGitRepositoryList = listOf<GitRepository>()

    companion object {

        private const val REQUEST_PAGE = 1

    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mSelectRepositoryViewModel = SelectGitRepositoryViewModel(
            gitRepositoryRemoteDataSource = mGitRepositoryRemoteDataSource,
            contextProvider = TestContextProvider()
        ).apply {
            getStateLiveData().observeForever(mViewStateObserver)
        }
    }

    fun `when data source returns an empty GitRepository list`() {
        mGitRepositoryList = listOf()
    }

    fun `when data source returns filled GitRepository list`() {
        mGitRepositoryList = GitRepositoryFaker.getList()
    }

    fun `should success when data source returns the expected data`() =
        testCoroutineRule.runBlockingTest {
            `when`(mGitRepositoryRemoteDataSource.getGitRepositoryList(REQUEST_PAGE)).thenReturn(
                mGitRepositoryList
            )

            mSelectRepositoryViewModel.getGitRepositoryApiResponse(REQUEST_PAGE)

            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Loading)
            verify(mViewStateObserver).onChanged(
                SelectGitRepositoryViewModelState.Success(
                    mGitRepositoryList
                )
            )
        }

    fun `should throw error when data source throws exception`() =
        testCoroutineRule.runBlockingTest {
            val error = Error()
            `when`(mGitRepositoryRemoteDataSource.getGitRepositoryList(REQUEST_PAGE)).thenThrow(
                error
            )

            mSelectRepositoryViewModel.getGitRepositoryApiResponse(REQUEST_PAGE)

            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Loading)
            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Error(error))
        }

}