package br.com.argmax.githubconsumer.viewmodels.gitpullrequest.context

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto
import br.com.argmax.githubconsumer.viewmodels.utils.faker.GitPullRequestDtoFaker
import br.com.argmax.githubconsumer.service.gitpullrequest.GitPullRequestRemoteDataSource
import br.com.argmax.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel
import br.com.argmax.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel.SelectGitPullRequestViewModelState
import br.com.argmax.githubconsumer.viewmodels.utils.TestContextProvider
import br.com.argmax.githubconsumer.viewmodels.utils.TestCoroutineRule
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
    private lateinit var mGitPullRequestRemoteDataSource: GitPullRequestRemoteDataSource

    @Mock
    private lateinit var mViewStateObserver: Observer<SelectGitPullRequestViewModelState>

    private lateinit var mSelectPullRequestViewModel: SelectGitPullRequestViewModel

    private var mGitPullRequestDtoList = listOf<GitPullRequestDto>()

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

    fun `when data source returns an empty GitPullRequestDto list`() {
        mGitPullRequestDtoList = listOf()
    }

    fun `when data source returns filled GitPullRequestDto list`() {
        mGitPullRequestDtoList = GitPullRequestDtoFaker.getList()
    }

    fun `should success when data source returns the expected data`() =
        testCoroutineRule.runBlockingTest {
            `when`(
                mGitPullRequestRemoteDataSource.getGitPullRequestDtoList(
                    repository = FAKE_REPOSITORY_NAME,
                    owner = FAKE_USER_LOGIN,
                    page = FAKE_REQUEST_PAGE
                )
            ).thenReturn(
                mGitPullRequestDtoList
            )

            mSelectPullRequestViewModel.getGitPullRequestDtoList(
                repository = FAKE_REPOSITORY_NAME,
                owner = FAKE_USER_LOGIN,
                page = FAKE_REQUEST_PAGE
            )

            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Loading)
            verify(mViewStateObserver).onChanged(
                SelectGitPullRequestViewModelState.Success(
                    mGitPullRequestDtoList
                )
            )
        }

    fun `should throw error when data source throws exception`() =
        testCoroutineRule.runBlockingTest {
            val error = Error()
            `when`(
                mGitPullRequestRemoteDataSource.getGitPullRequestDtoList(
                    repository = FAKE_REPOSITORY_NAME,
                    owner = FAKE_USER_LOGIN,
                    page = FAKE_REQUEST_PAGE
                )
            ).thenThrow(
                error
            )

            mSelectPullRequestViewModel.getGitPullRequestDtoList(
                repository = FAKE_REPOSITORY_NAME,
                owner = FAKE_USER_LOGIN,
                page = FAKE_REQUEST_PAGE
            )

            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Loading)
            verify(mViewStateObserver).onChanged(SelectGitPullRequestViewModelState.Error(error))
        }

}