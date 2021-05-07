package br.com.argmax.githubconsumer.ui.gitpullrequests.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitPullRequestCardViewHolderBinding
import br.com.argmax.githubconsumer.ui.components.pullrequestcard.dtos.GitPullRequestCardDto
import br.com.argmax.githubconsumer.ui.components.repositorycard.dto.GitRepositoryCardDto
import br.com.argmax.githubconsumer.ui.gitpullrequests.listeners.OnPullRequestClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.git_pull_request_card_view_holder.*

class SelectGitPullRequestAdapter(
    val onPullRequestClickListener: OnPullRequestClickListener
) : Adapter<SelectGitPullRequestAdapter.GitPullRequestCardViewHolder>() {

    private var mData = listOf<GitPullRequestCardDto>()

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

    fun replaceData(list: List<GitPullRequestCardDto>?) {
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

        fun updateData(gitPullRequestCardDto: GitPullRequestCardDto) {
            gitPullRequestCard.setPullRequestCardDto(gitPullRequestCardDto)
        }

        override fun onClick(view: View?) {
            val adapterPosition = this.adapterPosition
            val gitPullRequestCardDto = mData[adapterPosition]
            val gitPullRequestUrl = gitPullRequestCardDto.gitPullRequestUrl

            onPullRequestClickListener.onClick(gitPullRequestUrl)
        }

    }

}
