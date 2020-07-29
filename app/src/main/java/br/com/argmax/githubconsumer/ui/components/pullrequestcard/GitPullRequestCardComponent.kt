package br.com.argmax.githubconsumer.ui.components.pullrequestcard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitPullRequestCardComponentBinding
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto

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

    fun setPullRequestCardDto(
        gitPullRequestCardDto: GitPullRequestCardDto
    ) {
        mBinding?.gitPullRequestCardDto = gitPullRequestCardDto
        mBinding?.executePendingBindings()
    }

}