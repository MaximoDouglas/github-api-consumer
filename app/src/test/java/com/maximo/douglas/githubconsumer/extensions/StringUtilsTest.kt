package com.maximo.douglas.githubconsumer.extensions

import com.maximo.douglas.githubconsumer.testutils.StringUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class StringUtilsTest {

    companion object {

        private const val TEXT_TO_COMPACT = "Lorem Ipsum is simply dummy text of the " +
                "printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s"

        private const val COMPACTED_TEXT =
            "Lorem Ipsum is simply dummy text of the printing and typeset..."

        private const val OPEN_PULL_REQUESTS_QUANTITY = 6

        private const val OPEN_PULL_REQUESTS_LABEL = "6 open"

        private const val CLOSED_PULL_REQUESTS_QUANTITY = 42

        private const val CLOSED_PULL_REQUESTS_LABEL = " / 42 closed"

    }

    @Test
    fun test_if_compactStringWithDots_is_working_correctly() {
        assertEquals(COMPACTED_TEXT, StringUtils.compactStringWithDots(TEXT_TO_COMPACT))
    }

    @Test
    fun test_if_gitPullRequestOpenLabelStringFormat_is_working_correctly() {
        assertEquals(
            OPEN_PULL_REQUESTS_LABEL, StringUtils.gitPullRequestOpenLabelStringFormat(
                OPEN_PULL_REQUESTS_QUANTITY
            )
        )
    }

    @Test
    fun test_if_gitPullRequestClosedLabelStringFormat_is_working_correctly() {
        assertEquals(
            CLOSED_PULL_REQUESTS_LABEL, StringUtils.gitPullRequestClosedLabelStringFormat(
                CLOSED_PULL_REQUESTS_QUANTITY
            )
        )
    }

}