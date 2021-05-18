package com.maximo.douglas.githubconsumer.ui.components.repositorycard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitRepositoryCardComponentBinding
import com.maximo.douglas.domain.entity.gitrepository.GitRepository

class GitRepositoryCardComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var mBinding: GitRepositoryCardComponentBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.git_repository_card_component,
            this,
            true
        )

    fun setRepositoryCard(
        gitRepository: GitRepository
    ) {
        mBinding?.gitRepository = gitRepository
        mBinding?.executePendingBindings()
    }

}