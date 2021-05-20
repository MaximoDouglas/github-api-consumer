package com.maximo.douglas.features.components.repositorycard

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.maximo.douglas.domain.entity.gitrepository.GitRepository
import com.maximo.douglas.features.R
import com.maximo.douglas.features.databinding.GitRepositoryCardComponentBinding

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