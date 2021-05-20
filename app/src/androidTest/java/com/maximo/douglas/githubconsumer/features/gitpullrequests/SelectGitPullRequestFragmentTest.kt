package com.maximo.douglas.githubconsumer.features.gitpullrequests

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.argmax.githubconsumer.R
import com.maximo.douglas.commons.utils.NavigationArgumentKeys.KEY_OWNER_LOGIN
import com.maximo.douglas.commons.utils.NavigationArgumentKeys.KEY_REPOSITORY_NAME
import com.maximo.douglas.commons.utils.StringUtils.compactStringWithDots
import com.maximo.douglas.commons.utils.StringUtils.gitPullRequestClosedLabelStringFormat
import com.maximo.douglas.commons.utils.StringUtils.gitPullRequestOpenLabelStringFormat
import com.maximo.douglas.githubconsumer.testutils.FileUtils
import com.maximo.douglas.githubconsumer.testutils.RecyclerViewMatcher.Companion.withRecyclerView
import com.maximo.douglas.githubconsumer.testutils.ThreadUtil.waitViewToComplete
import com.maximo.douglas.features.gitpullrequests.SelectGitPullRequestFragment
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test

class SelectGitPullRequestFragmentTest {

    companion object {

        private const val REPOSITORY_NAME = "CS-Notes"

        private const val PULL_REQUEST_TITLE = "fixed (修改剑指offer35，47，目录问题)"

        private const val PULL_REQUEST_HTML_URL = "https://github.com/CyC2018/CS-Notes/pull/957"

        private const val REPOSITORY_OWNER_NAME = "CyC2018"

        private const val USER_NAME = "TC-zerol"

        private val OPEN_LABEL_TEXT = gitPullRequestOpenLabelStringFormat(8)

        private val CLOSED_LABEL_TEXT = gitPullRequestClosedLabelStringFormat(22)

        private val PULL_REQUEST_BODY = compactStringWithDots(
            "剑指offer 35题\r\n返回链表除头节点为clone节点外，其余节点为原节点。" +
                    "\r\n\r\n剑指offer 47题\r\n逻辑错误\r\n\r\n剑指offer 43题\r\n目录错误，无法链接"
        )

    }

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        setupMockWebServer()
        launchFragment()
        waitViewToComplete()
    }

    private fun launchFragment() {
        val themeResId: Int = R.style.AppTheme
        val initialState = Lifecycle.State.RESUMED

        val fragmentArgs = Bundle()
        fragmentArgs.putString(KEY_OWNER_LOGIN, REPOSITORY_OWNER_NAME)
        fragmentArgs.putString(KEY_REPOSITORY_NAME, REPOSITORY_NAME)

        FragmentScenario.Companion.launchInContainer(
            com.maximo.douglas.features.gitpullrequests.SelectGitPullRequestFragment::class.java,
            fragmentArgs,
            themeResId,
            initialState,
            null
        )
    }

    @After
    fun tearDown() {
        mockWebServer.close()
    }

    @Test
    fun test_if_toolbar_is_displayed() {
        onView(ViewMatchers.withId(R.id.select_git_pull_request_fragment_toolbar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_toolbar_title_is_set_correctly() {
        onView(ViewMatchers.withId(R.id.select_git_pull_request_fragment_toolbar_title))
            .check(matches(withText(REPOSITORY_NAME)))
    }

    @Test
    fun test_if_open_label_text_is_set_correctly() {
        onView(ViewMatchers.withId(R.id.select_git_pull_request_fragment_open_pull_request_text_view))
            .check(matches(withText(OPEN_LABEL_TEXT)))
    }

    @Test
    fun test_if_closed_label_text_is_set_correctly() {
        onView(ViewMatchers.withId(R.id.select_git_pull_request_fragment_closed_pull_request_text_view))
            .check(matches(withText(CLOSED_LABEL_TEXT)))
    }

    @Test
    fun test_if_recyclerview_is_displayed() {
        onView(ViewMatchers.withId(R.id.select_git_pull_request_fragment_recycler_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_recyclerview_item_title_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_git_pull_request_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_pull_request_card_title_text_view)
        ).check(matches(withText(PULL_REQUEST_TITLE)))
    }

    @Test
    fun test_if_recyclerview_item_body_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_git_pull_request_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_pull_request_card_body_text_view)
        ).check(matches(withText(PULL_REQUEST_BODY)))
    }

    @Test
    fun test_if_recyclerview_item_user_image_is_displayed() {
        onView(
            withRecyclerView(R.id.select_git_pull_request_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_pull_request_card_user_image_image_view)
        ).check(matches(isDisplayed()))
    }

    @Test
    fun test_if_recyclerview_item_user_name_is_set_correctly() {
        onView(
            withRecyclerView(R.id.select_git_pull_request_fragment_recycler_view)
                .atPositionOnView(0, R.id.git_pull_request_card_user_name_text_view)
        ).check(matches(withText(USER_NAME)))
    }

    @Test
    fun test_if_click_on_recyclerview_item_makes_intent_to_web_browser() {
        Intents.init()

        onView(
            withRecyclerView(R.id.select_git_pull_request_fragment_recycler_view)
                .atPositionOnView(0, R.id.gitPullRequestCard)
        ).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW))
        Intents.intended(IntentMatchers.hasData(Uri.parse(PULL_REQUEST_HTML_URL)))
        Intents.release()
    }

    private fun setupMockWebServer() {
        val endpointToPullRequests = "/repos/CyC2018/CS-Notes/pulls?page=1&state=all"

        val dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                when (request.path) {
                    endpointToPullRequests -> return MockResponse()
                        .setResponseCode(200)
                        .setBody(FileUtils.getJsonFromFile("jsonfiles/pullrequests/git_pull_request_api_response_cyc2018_cs_notes.json"))
                }

                return MockResponse().setResponseCode(404)
            }
        }

        mockWebServer.dispatcher = dispatcher
        mockWebServer.start(8500)
    }

}