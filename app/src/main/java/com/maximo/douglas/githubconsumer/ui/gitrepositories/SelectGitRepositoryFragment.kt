package com.maximo.douglas.githubconsumer.ui.gitrepositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitRepositoryFragmentBinding
import com.maximo.douglas.githubconsumer.domain.entities.gitrepository.GitRepository
import com.maximo.douglas.githubconsumer.testutils.EndlessRecyclerOnScrollListener
import com.maximo.douglas.githubconsumer.ui.gitrepositories.SelectGitRepositoryFragmentDirections.actionSelectRepositoryFragmentToSelectGitPullRequestFragment
import com.maximo.douglas.githubconsumer.ui.gitrepositories.SelectGitRepositoryViewModel.SelectGitRepositoryViewModelState
import com.maximo.douglas.githubconsumer.ui.gitrepositories.adapters.SelectGitRepositoryAdapter
import com.maximo.douglas.githubconsumer.ui.gitrepositories.listeners.OnGitRepositoryClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectGitRepositoryFragment : Fragment(), OnGitRepositoryClickListener {

    private val mViewModel: SelectGitRepositoryViewModel by viewModel()

    private var mBinding: SelectGitRepositoryFragmentBinding? = null
    private var mAdapter = SelectGitRepositoryAdapter(this)
    private var gitRepositoryList: MutableList<GitRepository>? = null

    private var mApiRequestPage: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_git_repository_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectRepositoryFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectRepositoryFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectRepositoryFragmentRecyclerView?.adapter = mAdapter
        mBinding?.selectRepositoryFragmentRecyclerView?.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                mApiRequestPage++
                loadData()
            }
        })
    }

    private fun setupViewModel() {
        mViewModel.getStateLiveData().observe(
            viewLifecycleOwner, { viewModelState ->
                handleViewModelState(viewModelState)
            })

        if (gitRepositoryList == null) {
            loadData()
        }
    }

    private fun handleViewModelState(viewModelState: SelectGitRepositoryViewModelState) {
        when (viewModelState) {
            is SelectGitRepositoryViewModelState.Loading -> {
                if (mAdapter.itemCount == 0) {
                    mBinding?.contentLoadingProgressBar?.visibility = View.VISIBLE
                }
            }

            is SelectGitRepositoryViewModelState.Error -> {
                val throwable = viewModelState.throwable
                println(throwable)
                mBinding?.contentLoadingProgressBar?.visibility = View.GONE
            }

            is SelectGitRepositoryViewModelState.Success -> {
                val data = viewModelState.data
                onSuccess(data)
                mBinding?.contentLoadingProgressBar?.visibility = View.GONE
            }
        }
    }

    private fun onSuccess(data: List<GitRepository>) {
        if (gitRepositoryList != null) {
            gitRepositoryList?.addAll(data)
        } else {
            gitRepositoryList = data.toMutableList()
        }

        mAdapter.replaceData(gitRepositoryList)
    }

    private fun loadData() {
        mViewModel.getGitRepositoryApiResponse(mApiRequestPage)
    }

    override fun onClick(ownerLogin: String, repositoryName: String) {
        findNavController().navigate(
            actionSelectRepositoryFragmentToSelectGitPullRequestFragment(
                ownerLogin,
                repositoryName
            )
        )
    }

}