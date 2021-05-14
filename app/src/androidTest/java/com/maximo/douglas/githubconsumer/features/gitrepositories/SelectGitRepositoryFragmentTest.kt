package com.maximo.douglas.githubconsumer.features.gitrepositories

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.argmax.githubconsumer.R
import com.maximo.douglas.githubconsumer.MainActivity
import com.maximo.douglas.githubconsumer.utils.FileUtils.getJsonFromFile
import com.maximo.douglas.githubconsumer.utils.RecyclerViewMatcher.Companion.withRecyclerView
import com.maximo.douglas.githubconsumer.utils.StringUtils
import com.maximo.douglas.githubconsumer.utils.ThreadUtil.waitViewToComplete
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class SelectGitRepositoryFragmentTest {

    companion object {

        private const val REPOSITORY_NAME = "CS-Notes"

        private const val REPOSITORY_OWNER_NAME = "CyC2018"

        private const val REPOSITORY_STAR_COUNT = 106626.toString()

        private const val REPOSITORY_FORKS_COUNT = 34768.toString()

        private val REPOSITORY_DESCRIPTION = StringUtils.compactStringWithDots(
            ":books: 技术面试必备基础知识、Leetcode、计算机操作系统、计算机网络、系统设计、Java、Python、C++"
        )

    }

    private val mMockWebServer = MockWebServer()
    private var mActivityScenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setup() {
        setupMockWebServer()
        mActivityScenario = ActivityScenario.launch(MainActivity::class.java)
        waitViewToComplete()
    }

    @After
    fun tearDown() {
        mMockWebServer.close()
    }

    @Test
    fun test_if_toolbar_is_displayed() {
        onView(withId(R.id.select_repository_fragment_toolbar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_toolbar_title_is_set_correctly() {
        onView(withId(R.id.select_repository_fragment_toolbar_title))
            .check(matches(withText(R.string.select_repository_fragment_toolbar_text)))
    }

    @Test
    fun test_if_recyclerview_is_displayed() {
        onView(withId(R.id.select_repository_fragment_recycler_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_recyclerview_item_name_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_repository_name_text_view)
        ).check(matches(withText(REPOSITORY_NAME)))
    }

    @Test
    fun test_if_recyclerview_item_description_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_git_repository_description_text_view)
        ).check(matches(withText(REPOSITORY_DESCRIPTION)))
    }

    @Test
    fun test_if_recyclerview_item_stars_count_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_git_repository_stars_text_view)
        ).check(matches(withText(REPOSITORY_STAR_COUNT)))
    }

    @Test
    fun test_if_recyclerview_item_forks_count_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_git_repository_forks_text_view)
        ).check(matches(withText(REPOSITORY_FORKS_COUNT)))
    }

    @Test
    fun test_if_recyclerview_item_user_image_is_displayed() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_user_image_image_view)
        ).check(matches(isDisplayed()))
    }

    @Test
    fun test_if_recyclerview_item_user_name_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_repository_card_user_name_text_view)
        ).check(matches(withText(REPOSITORY_OWNER_NAME)))
    }

    @Test
    fun test_if_click_on_repository_item_navigate_to_pull_request_fragment() {
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(
                    0,
                    R.id.gitRepositoryCard
                )
        ).perform(ViewActions.click())

        onView(withId(R.id.select_git_pull_request_fragment_toolbar)).check(matches(isDisplayed()))
    }

    private fun setupMockWebServer() {
        val mockedApiResponse = MockResponse().setBody(
            getJsonFromFile("jsonfiles/repositories/git_repository_api_response.json")
        )

        mockedApiResponse.setResponseCode(200)
        mMockWebServer.enqueue(mockedApiResponse)
        mMockWebServer.start(8500)
    }

}