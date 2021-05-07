package br.com.argmax.githubconsumer.components.utils

import android.app.Activity
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController

@RunWith(RobolectricTestRunner::class)
abstract class BaseComponentTest {

    private lateinit var activityController: ActivityController<Activity>

    @Before
    fun setup() {
        activityController = Robolectric.buildActivity(Activity::class.java)
            .create()
            .start()
            .resume()
            .visible()

        val activity: Activity = activityController.get()
        setupComponent(activity)
    }

    abstract fun setupComponent(activity: Activity)

    @After
    fun tearDown() {
        activityController
            .pause()
            .stop()
            .destroy()

        stopKoin()
    }

}