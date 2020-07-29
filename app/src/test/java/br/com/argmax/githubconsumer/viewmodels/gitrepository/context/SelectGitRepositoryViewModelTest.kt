package br.com.argmax.githubconsumer.viewmodels.gitrepository.context

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.argmax.githubconsumer.domain.entities.repository.GitRepositoryDto
import br.com.argmax.githubconsumer.service.gitrepository.GitRepositoryRemoteDataSource
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryViewModel
import br.com.argmax.githubconsumer.ui.modules.gitrepositories.SelectGitRepositoryViewModel.SelectGitRepositoryViewModelState
import br.com.argmax.githubconsumer.viewmodels.utils.TestContextProvider
import br.com.argmax.githubconsumer.viewmodels.utils.TestCoroutineRule
import br.com.argmax.githubconsumer.viewmodels.utils.faker.GitRepositoryDtoFaker
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
    private lateinit var mGitRepositoryRemoteDataSource: GitRepositoryRemoteDataSource

    @Mock
    private lateinit var mViewStateObserver: Observer<SelectGitRepositoryViewModelState>

    private lateinit var mSelectRepositoryViewModel: SelectGitRepositoryViewModel

    private var mGitRepositoryDtoList = listOf<GitRepositoryDto>()

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

    fun `when data source returns an empty GitRepositoryDto list`() {
        mGitRepositoryDtoList = listOf()
    }

    fun `when data source returns filled GitRepositoryDto list`() {
        mGitRepositoryDtoList = GitRepositoryDtoFaker.getList()
    }

    fun `should success when data source returns the expected data`() =
        testCoroutineRule.runBlockingTest {
            `when`(mGitRepositoryRemoteDataSource.getGitRepositoryDtoList(REQUEST_PAGE)).thenReturn(
                mGitRepositoryDtoList
            )

            mSelectRepositoryViewModel.getGitRepositoryApiResponse(REQUEST_PAGE)

            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Loading)
            verify(mViewStateObserver).onChanged(
                SelectGitRepositoryViewModelState.Success(
                    mGitRepositoryDtoList
                )
            )
        }

    fun `should throw error when data source throws exception`() =
        testCoroutineRule.runBlockingTest {
            val error = Error()
            `when`(mGitRepositoryRemoteDataSource.getGitRepositoryDtoList(REQUEST_PAGE)).thenThrow(
                error
            )

            mSelectRepositoryViewModel.getGitRepositoryApiResponse(REQUEST_PAGE)

            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Loading)
            verify(mViewStateObserver).onChanged(SelectGitRepositoryViewModelState.Error(error))
        }

}