package com.maximo.douglas.githubconsumer.viewmodels.gitpullrequest.context

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest
import com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestRemoteDataSource
import com.maximo.douglas.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel
import com.maximo.douglas.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel.SelectGitPullRequestViewModelState
import com.maximo.douglas.githubconsumer.viewmodels.utils.TestContextProvider
import com.maximo.douglas.githubconsumer.viewmodels.utils.TestCoroutineRule
import com.maximo.douglas.githubconsumer.viewmodels.utils.faker.GitPullRequestFaker
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
open class SelectGitPullRequestViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mGitPullRequestRemoteDataSource: com.maximo.douglas.data.remote.gitpullrequest.GitPullRequestRemoteDataSource

    @Mock
    private lateinit var mViewStateObserver: Observer<SelectGitPullRequestViewModelState>

    private lateinit var mSelectPullRequestViewModel: SelectGitPullRequestViewModel

    private var mGitPullRequestList = listOf<GitPullRequest>()

    companion object {

        private const val FAKE_REQUEST_PAGE = 1

        private const val FAKE_USER_LOGIN = "CyC2018"

        private const val FAKE_REPOSITORY_NAME = "CS-Notes"

    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        mSelectPullRequestViewModel = SelectGitPullRequestViewModel(
            gitPullRequestRemoteDataSource = mGitPullRequestRemoteDataSource,
            contextProvider = TestContextProvider()
        ).apply {
            getStateLiveData().observeForever(mViewStateObserver)
        }
    }

    fun `when data source returns an empty GitPullRequest list`() {
        mGitPullRequestList = listOf()
    }

    fun `when data source returns filled GitPullRequest list`() {
        mGitPullRequestList = GitPullRequestFaker.getList()
    }

    fun `should success when data source returns the expected data`() =
        testCoroutineRule.runBlockingTest {
            `when`(
                mGitPullRequestRemoteDataSource.getGitPullRequestList(
                    repository = FAKE_REPOSITORY_NAME,
                    owner = FAKE_USER_LOGIN,
                    page = FAKE_REQUEST_PAGE
                )
            ).thenReturn(
                mGitPullRequestList
            )

            mSelectPullRequestViewModel.getGitPullRequestList(
                repository = FAKE_REPOSITORY_NAME,
                owner = FAKE_USER_LOGIN,
                page = FAKE_REQUEST_PAGE
            )

            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Loading)
            verify(mViewStateObserver).onChanged(
                SelectGitPullRequestViewModelState.Success(
                    mGitPullRequestList
                )
            )
        }

    fun `should throw error when data source throws exception`() =
        testCoroutineRule.runBlockingTest {
            val error = Error()
            `when`(
                mGitPullRequestRemoteDataSource.getGitPullRequestList(
                    repository = FAKE_REPOSITORY_NAME,
                    owner = FAKE_USER_LOGIN,
                    page = FAKE_REQUEST_PAGE
                )
            ).thenThrow(
                error
            )

            mSelectPullRequestViewModel.getGitPullRequestList(
                repository = FAKE_REPOSITORY_NAME,
                owner = FAKE_USER_LOGIN,
                page = FAKE_REQUEST_PAGE
            )

            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Loading)
            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Error(error))
        }

}