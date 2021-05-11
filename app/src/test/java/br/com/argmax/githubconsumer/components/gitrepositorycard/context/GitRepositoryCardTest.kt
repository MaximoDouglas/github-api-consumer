package br.com.argmax.githubconsumer.components.gitrepositorycard.context

import android.app.Activity
import android.view.View
import br.com.argmax.githubconsumer.components.utils.BaseComponentTest
import br.com.argmax.githubconsumer.domain.entities.gitrepository.GitRepository
import br.com.argmax.githubconsumer.domain.entities.user.GitUser
import br.com.argmax.githubconsumer.ui.components.repositorycard.GitRepositoryCardComponent
import br.com.argmax.githubconsumer.utils.StringUtils.compactStringWithDots
import kotlinx.android.synthetic.main.git_repository_card_component.view.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

open class GitRepositoryCardTest : BaseComponentTest() {

    companion object {

        private const val REPOSITORY_NAME =
            "Lorem Ipsum is simply dummy text of the printing and typesetting"

        private const val LONG_REPOSITORY_DESCRIPTION = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley"

        private const val FORKS_QUANTITY = 640

        private const val STARS_QUANTITY = 98

        private const val USER_IMAGE_URL = "https://picsum.photos/200"

        private const val USER_NAME =
            "survived not only five centuries, but also the leap into electronic"

    }

    private var mGitRepositoryCardComponent: GitRepositoryCardComponent? = null

    override fun setupComponent(activity: Activity) {
        mGitRepositoryCardComponent = GitRepositoryCardComponent(activity)
    }

    fun `when repository card has all data`() {
        val gitRepository = GitRepository(
            name = REPOSITORY_NAME,
            description = LONG_REPOSITORY_DESCRIPTION,
            forksCount = FORKS_QUANTITY,
            stargazersCount = STARS_QUANTITY,
            owner = GitUser(
                login = USER_NAME,
                avatarUrl = USER_IMAGE_URL
            )
        )

        mGitRepositoryCardComponent?.setRepositoryCard(gitRepository)
    }

    fun `when repository card has no description`() {
        val gitRepository = GitRepository(
            name = REPOSITORY_NAME,
            description = null,
            forksCount = FORKS_QUANTITY,
            stargazersCount = STARS_QUANTITY,
            owner = GitUser(
                login = USER_NAME,
                avatarUrl = USER_IMAGE_URL
            )
        )

        mGitRepositoryCardComponent?.setRepositoryCard(gitRepository)
    }

    fun `assert that repository name is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_repository_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository name is set correctly`() {
        assertEquals(
            REPOSITORY_NAME,
            mGitRepositoryCardComponent?.git_repository_card_repository_name_text_view?.text.toString()
        )
    }

    fun `assert that repository description is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository description is set correctly`() {
        val maxLengthDescription = 60
        val shortString = compactStringWithDots(LONG_REPOSITORY_DESCRIPTION, maxLengthDescription)

        assertEquals(
            shortString,
            mGitRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.text.toString()
        )
    }

    fun `assert that repository description is gone`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.visibility == View.GONE)
    }

    fun `assert that repository description is null or empty`() {
        assertTrue(
            mGitRepositoryCardComponent?.git_repository_card_git_repository_description_text_view?.text?.toString()
                .isNullOrEmpty()
        )
    }

    fun `assert that repository stars quantity label is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_git_repository_stars_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository stars quantity label is set correctly`() {
        val starsQuantityString = STARS_QUANTITY.toString()

        assertEquals(
            starsQuantityString,
            mGitRepositoryCardComponent?.git_repository_card_git_repository_stars_text_view?.text.toString()
        )
    }

    fun `assert that repository forks quantity label is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_git_repository_forks_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that repository forks quantity label is set correctly`() {
        val forksQuantityString = FORKS_QUANTITY.toString()

        assertEquals(
            forksQuantityString,
            mGitRepositoryCardComponent?.git_repository_card_git_repository_forks_text_view?.text.toString()
        )
    }

    fun `assert that user image is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_user_image_image_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is visible`() {
        assertTrue(mGitRepositoryCardComponent?.git_repository_card_user_name_text_view?.visibility == View.VISIBLE)
    }

    fun `assert that user name is set correctly`() {
        assertEquals(
            USER_NAME,
            mGitRepositoryCardComponent?.git_repository_card_user_name_text_view?.text.toString()
        )
    }

}