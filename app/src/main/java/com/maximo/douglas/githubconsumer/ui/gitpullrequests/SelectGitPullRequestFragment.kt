package com.maximo.douglas.githubconsumer.ui.gitpullrequests

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitPullRequestFragmentBinding
import com.maximo.douglas.commons.utils.FragmentUtils.bundleContainsKeys
import com.maximo.douglas.commons.utils.NavigationArgumentKeys.KEY_OWNER_LOGIN
import com.maximo.douglas.commons.utils.NavigationArgumentKeys.KEY_REPOSITORY_NAME
import com.maximo.douglas.commons.utils.StringUtils.gitPullRequestClosedLabelStringFormat
import com.maximo.douglas.commons.utils.StringUtils.gitPullRequestOpenLabelStringFormat
import com.maximo.douglas.domain.entity.gitpullrequest.GitPullRequest
import com.maximo.douglas.domain.entity.gitpullrequest.PullRequestStateEnum
import com.maximo.douglas.githubconsumer.ui.gitpullrequests.SelectGitPullRequestViewModel.SelectGitPullRequestViewModelState
import com.maximo.douglas.githubconsumer.ui.gitpullrequests.adapters.SelectGitPullRequestAdapter
import com.maximo.douglas.githubconsumer.ui.gitpullrequests.listeners.OnPullRequestClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectGitPullRequestFragment : Fragment(), OnPullRequestClickListener {

    private val mViewModel: SelectGitPullRequestViewModel by viewModel()

    private var mBinding: SelectGitPullRequestFragmentBinding? = null
    private var mAdapter = SelectGitPullRequestAdapter(this)

    private var mOwnerLogin: String? = null
    private var mRepositoryName: String? = null
    private var gitPullRequestList: MutableList<GitPullRequest>? = null
    private var mApiRequestPage: Int = 1

    private var mOpenPullRequestCounter: Int = 0
    private var mClosedPullRequestCounter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.select_git_pull_request_fragment,
            container,
            false
        )

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            extractDataFromBundle(savedInstanceState)
        } else if (arguments != null) {
            extractDataFromBundle(arguments)
        }

        setupToolbar()
        setupRecyclerView()
        setupViewModel()
    }

    private fun extractDataFromBundle(bundle: Bundle?) {
        val bundleContainsKeys = bundleContainsKeys(bundle, KEY_OWNER_LOGIN, KEY_REPOSITORY_NAME)

        if (bundleContainsKeys) {
            mOwnerLogin = bundle?.getString(KEY_OWNER_LOGIN)
            mRepositoryName = bundle?.getString(KEY_REPOSITORY_NAME)
        }
    }

    private fun setupToolbar() {
        mBinding?.selectGitPullRequestFragmentToolbar?.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        mBinding?.selectGitPullRequestFragmentToolbarTitle?.text = mRepositoryName
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        mBinding?.selectGitPullRequestFragmentRecyclerView?.layoutManager = linearLayoutManager

        mBinding?.selectGitPullRequestFragmentRecyclerView?.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        mBinding?.selectGitPullRequestFragmentRecyclerView?.adapter = mAdapter
        mBinding?.selectGitPullRequestFragmentRecyclerView?.addOnScrollListener(object :
            com.maximo.douglas.commons.utils.EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                mApiRequestPage++
                loadData()
            }
        })
    }

    private fun loadData() {
        mOwnerLogin?.let { owner ->
            mRepositoryName?.let { repository ->
                mViewModel.getGitPullRequestList(
                    owner,
                    repository,
                    mApiRequestPage
                )
            }
        }
    }

    private fun setupViewModel() {
        mViewModel.getStateLiveData().observe(
            viewLifecycleOwner,
            Observer { viewModelState ->
                handleViewModelState(viewModelState)
            })

        if (gitPullRequestList == null) {
            loadData()
        }
    }

    private fun handleViewModelState(viewModelState: SelectGitPullRequestViewModelState) {
        when (viewModelState) {
            is SelectGitPullRequestViewModelState.Loading -> {
                if (mAdapter.itemCount == 0) {
                    mBinding?.contentLoadingProgressBar?.visibility = View.VISIBLE
                }
            }

            is SelectGitPullRequestViewModelState.Error -> {
                val throwable = viewModelState.throwable
                println(throwable)
                mBinding?.contentLoadingProgressBar?.visibility = View.GONE
            }

            is SelectGitPullRequestViewModelState.Success -> {
                val gitPullRequestList = viewModelState.data
                onSuccess(gitPullRequestList)
                mBinding?.contentLoadingProgressBar?.visibility = View.GONE
            }
        }
    }

    private fun onSuccess(response: List<GitPullRequest>) {
        val openPullRequestQuantity = getOpenPullRequestQuantity(response)

        mOpenPullRequestCounter += openPullRequestQuantity
        mClosedPullRequestCounter += response.size - mOpenPullRequestCounter

        if (gitPullRequestList != null) {
            gitPullRequestList?.addAll(response)
        } else {
            gitPullRequestList = response.toMutableList()
        }

        mAdapter.replaceData(gitPullRequestList)
        updateStateCounter()
    }

    private fun getOpenPullRequestQuantity(gitPullRequestList: List<GitPullRequest>): Int {
        var openPullRequestQuantity = 0

        gitPullRequestList.forEach { gitPullRequest ->
            if (gitPullRequest.state == PullRequestStateEnum.OPEN.value) {
                openPullRequestQuantity++
            }
        }

        return openPullRequestQuantity
    }

    private fun updateStateCounter() {
        val openLabelText = gitPullRequestOpenLabelStringFormat(mOpenPullRequestCounter)
        val closedLabelText = gitPullRequestClosedLabelStringFormat(mClosedPullRequestCounter)

        mBinding?.selectGitPullRequestFragmentOpenPullRequestTextView?.text = openLabelText
        mBinding?.selectGitPullRequestFragmentClosedPullRequestTextView?.text = closedLabelText
        mBinding?.executePendingBindings()
    }

    override fun onClick(pullRequestUrl: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pullRequestUrl))
        startActivity(browserIntent)
    }

}