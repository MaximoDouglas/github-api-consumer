package com.maximo.douglas.features.components.pullrequestcard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.maximo.douglas.domain.entity.gitpullrequest.GitPullRequest
import com.maximo.douglas.features.R
import com.maximo.douglas.features.databinding.GitPullRequestCardComponentBinding

class GitPullRequestCardComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: GitPullRequestCardComponentBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.git_pull_request_card_component,
            this,
            true
        )

    fun setGitPullRequest(
        gitPullRequest: GitPullRequest
    ) {
        mBinding?.gitPullRequest = gitPullRequest
        mBinding?.executePendingBindings()
    }

}