package com.maximo.douglas.githubconsumer.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import br.com.argmax.githubconsumer.R
import com.maximo.douglas.githubconsumer.testutils.ThreadUtil.waitViewToComplete
import com.maximo.douglas.githubconsumer.ui.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private var activityScenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        waitViewToComplete()
    }

    @Test
    fun assert_that_container_layout_is_displayed() {
        onView(withId(R.id.main_activity_constraint_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_that_nav_host_fragment_is_displayed() {
        onView(withId(R.id.navHostFragment)).check(matches(isDisplayed()))
    }

}