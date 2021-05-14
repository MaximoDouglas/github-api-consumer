package com.maximo.douglas.githubconsumer.components.gitpullrequestcard.context

import android.app.Activity
import android.view.View
import com.maximo.douglas.domain.entities.gitpullrequest.GitPullRequest
import com.maximo.douglas.domain.entities.user.GitUser
import com.maximo.douglas.githubconsumer.components.utils.BaseComponentTest
import com.maximo.douglas.githubconsumer.ui.components.pullrequestcard.GitPullRequestCardComponent
import com.maximo.douglas.githubconsumer.utils.StringUtils.compactStringWithDots
import kotlinx.android.synthetic.main.git_pull_request_card_component.view.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

open class GitPullRequestCardTest : BaseComponentTest() {

    companion object {

        private const val PULL_REQUEST_TITLE =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

        private const val LONG_PULL_REQUEST_BODY = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley"

        private const val PULL_REQUEST_URL =
            "https://github.com/iluwatar/java-design-patterns/milestone/24"

        private const val USER_IMAGE_URL = "https://picsum.photos/200"

        private const val USER_NAME = "survived not only five centuries"

    }

    private var mGitPullRequestCardComponent: GitPullRequestCardComponent? = null

    override fun setupComponent(activity: Activity) {
        mGitPullRequestCardComponent = GitPullRequestCardComponent(activity)
    }

    fun `when pull request card has all data`() {
        val gitPullRequest = GitPullRequest(
            title = PULL_REQUEST_TITLE,
            body = LONG_PULL_REQUEST_BODY,
            htmlUrl = PULL_REQUEST_URL,
            user = GitUser(
                login = USER_NAME,
                avatarUrl = USER_IMAGE_URL
            )
        )

        mGitPullRequestCardComponent?.setGitPullRequest(gitPullRequest)
    }

    fun `when pull request card has no body`() {
        val gitPullRequest = GitPullRequest(
            title = PULL_REQUEST_TITLE,
            body = null,
            htmlUrl = PULL_REQUEST_URL,
            user = GitUser(
                login = USER_NAME,
                avatarUrl = USER_IMAGE_URL
            )
        )

        mGitPullRequestCardComponent?.setGitPullRequest(gitPullRequest)
    }

    fun `assert that pull request title is visible`() {
        assertTrue(mGitPullRequestCardComponent?.git_pull_request_card_title_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that pull request title is set correctly`() {
        assertEquals(
            PULL_REQUEST_TITLE,
            mGitPullRequestCardComponent?.git_pull_request_card_title_text_view?.text.toString()
        )
    }

    fun `assert that pull request body is visible`() {
        assertTrue(mGitPullRequestCardComponent?.git_pull_request_card_body_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that pull request body is set correctly`() {
        val maxLengthDescription = 60
        val shortString = compactStringWithDots(LONG_PULL_REQUEST_BODY, maxLengthDescription)

        assertEquals(
            shortString,
            mGitPullRequestCardComponent?.git_pull_request_card_body_text_view?.text.toString()
        )
    }

    fun `assert that pull request body is gone`() {
        assertTrue(mGitPullRequestCardComponent?.git_pull_request_card_body_text_view?.visibility == View.GONE)
    }

    fun `assert that pull request body is null or empty`() {
        assertTrue(
            mGitPullRequestCardComponent?.git_pull_request_card_body_text_view?.text?.toString()
                .isNullOrEmpty()
        )
    }

    fun `assert that user image is visible`() {
        assertTrue(mGitPullRequestCardComponent?.git_pull_request_card_user_image_image_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is visible`() {
        assertTrue(mGitPullRequestCardComponent?.git_pull_request_card_user_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is set correctly`() {
        assertEquals(
            USER_NAME,
            mGitPullRequestCardComponent?.git_pull_request_card_user_name_text_view?.text.toString()
        )
    }

}