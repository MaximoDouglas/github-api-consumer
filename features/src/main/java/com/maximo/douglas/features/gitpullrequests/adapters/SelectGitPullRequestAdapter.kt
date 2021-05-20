package com.maximo.douglas.features.gitpullrequests.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.maximo.douglas.domain.entity.gitpullrequest.GitPullRequest
import com.maximo.douglas.features.R
import com.maximo.douglas.features.databinding.GitPullRequestCardViewHolderBinding
import com.maximo.douglas.features.gitpullrequests.listeners.OnPullRequestClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.git_pull_request_card_view_holder.*

class SelectGitPullRequestAdapter(
    val onPullRequestClickListener: OnPullRequestClickListener
) : Adapter<SelectGitPullRequestAdapter.GitPullRequestCardViewHolder>() {

    private var mData = listOf<GitPullRequest>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitPullRequestCardViewHolder {
        val gitPullRequestCardViewHolderBinding: GitPullRequestCardViewHolderBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.git_pull_request_card_view_holder,
                parent,
                false
            )

        return GitPullRequestCardViewHolder(gitPullRequestCardViewHolderBinding.root)
    }

    override fun onBindViewHolder(holder: GitPullRequestCardViewHolder, position: Int) {
        holder.updateData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun replaceData(list: List<GitPullRequest>?) {
        list?.let {
            mData = it
        }
        notifyDataSetChanged()
    }

    inner class GitPullRequestCardViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), LayoutContainer, View.OnClickListener {

        init {
            gitPullRequestCard.setOnClickListener(this)
        }

        override val containerView: View?
            get() = itemView

        fun updateData(gitPullRequest: GitPullRequest) {
            gitPullRequestCard.setGitPullRequest(gitPullRequest)
        }

        override fun onClick(view: View?) {
            val adapterPosition = this.adapterPosition
            val gitPullRequest = mData[adapterPosition]
            val gitPullRequestUrl = gitPullRequest.htmlUrl

            onPullRequestClickListener.onClick(gitPullRequestUrl)
        }

    }

}
