package br.com.argmax.githubconsumer.ui.modules.gitpullrequests

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.argmax.githubconsumer.MainActivity
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.SelectGitPullRequestFragmentBinding
import br.com.argmax.githubconsumer.domain.entities.pullrequest.GitPullRequestDto
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.SelectGitPullRequestViewModel.SelectGitPullRequestViewModelState
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.adapters.SelectGitPullRequestAdapter
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.converters.GitPullRequestConverter.convertDtoListToCardDtoList
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.listeners.OnPullRequestClickListener
import br.com.argmax.githubconsumer.utils.EndlessRecyclerOnScrollListener
import br.com.argmax.githubconsumer.utils.FragmentUtils.bundleContainsKeys
import br.com.argmax.githubconsumer.utils.NavigationArgumentKeys.KEY_OWNER_LOGIN
import br.com.argmax.githubconsumer.utils.NavigationArgumentKeys.KEY_REPOSITORY_NAME
import br.com.argmax.githubconsumer.utils.StringUtils.gitPullRequestClosedLabelStringFormat
import br.com.argmax.githubconsumer.utils.StringUtils.gitPullRequestOpenLabelStringFormat
import javax.inject.Inject

class SelectGitPullRequestFragment : Fragment(), OnPullRequestClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel by viewModels<SelectGitPullRequestViewModel> { viewModelFactory }

    private var mBinding: SelectGitPullRequestFragmentBinding? = null
    private var mAdapter = SelectGitPullRequestAdapter(this)

    private var mOwnerLogin: String? = null
    private var mRepositoryName: String? = null
    private var gitPullRequestCardDtoList: MutableList<GitPullRequestCardDto>? = null
    private var mApiRequestPage: Int = 1

    private var mOpenPullRequestCounter: Int = 0
    private var mClosedPullRequestCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        extractDataFromBundle(savedInstanceState)
        extractDataFromBundle(arguments)
    }

    private fun extractDataFromBundle(bundle: Bundle?) {
        val bundleContainsKeys = bundleContainsKeys(bundle, KEY_OWNER_LOGIN, KEY_REPOSITORY_NAME)

        if (bundleContainsKeys) {
            mOwnerLogin = bundle?.getString(KEY_OWNER_LOGIN)
            mRepositoryName = bundle?.getString(KEY_REPOSITORY_NAME)
        }
    }

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

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupRecyclerView()
        setupViewModel()
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
            EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                mApiRequestPage++
                loadData()
            }
        })
    }

    private fun loadData() {
        mOwnerLogin?.let { owner ->
            mRepositoryName?.let { repository ->
                mViewModel.getGitPullRequestDtoList(
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

        if (gitPullRequestCardDtoList == null) {
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

    private fun onSuccess(response: List<GitPullRequestDto>) {
        val gitPullRequestCardDtoListConverterReturn = convertDtoListToCardDtoList(response)

        val pullRequestCardDtoList = gitPullRequestCardDtoListConverterReturn.first
        val pullRequestStatePair = gitPullRequestCardDtoListConverterReturn.second

        mOpenPullRequestCounter += pullRequestStatePair.first
        mClosedPullRequestCounter += pullRequestStatePair.second

        if (gitPullRequestCardDtoList != null) {
            gitPullRequestCardDtoList?.addAll(pullRequestCardDtoList)
        } else {
            gitPullRequestCardDtoList = pullRequestCardDtoList.toMutableList()
        }

        mAdapter.replaceData(gitPullRequestCardDtoList)
        updateStateCounter()
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