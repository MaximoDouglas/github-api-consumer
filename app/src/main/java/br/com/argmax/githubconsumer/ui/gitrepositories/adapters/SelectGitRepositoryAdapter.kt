package br.com.argmax.githubconsumer.ui.gitrepositories.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.databinding.GitRepositoryCardViewHolderBinding
import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository

import br.com.argmax.githubconsumer.ui.gitrepositories.listeners.OnGitRepositoryClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.git_repository_card_view_holder.*

class SelectGitRepositoryAdapter(
    val onGitRepositoryClickListener: OnGitRepositoryClickListener
) : Adapter<SelectGitRepositoryAdapter.GitRepositoryCardViewHolder>() {

    private var mData = listOf<GitRepository>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GitRepositoryCardViewHolder {
        val gitRepositoryCardViewHolderBinding: GitRepositoryCardViewHolderBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.git_repository_card_view_holder,
                parent,
                false
            )

        return GitRepositoryCardViewHolder(gitRepositoryCardViewHolderBinding.root)
    }

    override fun onBindViewHolder(holder: GitRepositoryCardViewHolder, position: Int) {
        holder.updateData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun replaceData(list: List<GitRepository>?) {
        list?.let {
            mData = it
        }
        notifyDataSetChanged()
    }

    inner class GitRepositoryCardViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), LayoutContainer, View.OnClickListener {

        override val containerView: View?
            get() = itemView

        init {
            gitRepositoryCard.setOnClickListener(this)
        }

        fun updateData(repositoryCard: GitRepository) {
            gitRepositoryCard.setRepositoryCard(repositoryCard)
        }

        override fun onClick(view: View?) {
            val gitRepositoryAdapterPosition = this.adapterPosition
            val gitRepository = mData[gitRepositoryAdapterPosition]

            onGitRepositoryClickListener.onClick(
                gitRepository.owner.login,
                gitRepository.name
            )
        }
    }

}
