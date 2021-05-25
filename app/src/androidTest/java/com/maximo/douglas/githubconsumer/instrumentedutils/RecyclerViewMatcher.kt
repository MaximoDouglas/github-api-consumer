package com.maximo.douglas.githubconsumer.instrumentedutils

import android.content.res.Resources
import android.content.res.Resources.NotFoundException
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class RecyclerViewMatcher(private val recyclerViewId: Int) {
    fun atPosition(position: Int): Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(
        position: Int,
        targetViewId: Int
    ): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            var resources: Resources? = null
            var childView: View? = null
            override fun describeTo(description: Description) {
                var idDescription = recyclerViewId.toString()
                if (resources != null) {
                    idDescription = try {
                        resources!!.getResourceName(recyclerViewId)
                    } catch (var4: NotFoundException) {
                        String.format("%s (resource name not found)", recyclerViewId)
                    }
                }
                description.appendText("RecyclerView with id: $idDescription at position: $position")
            }

            public override fun matchesSafely(view: View): Boolean {
                resources = view.resources
                if (childView == null) {
                    val recyclerView = view.rootView
                        .findViewById<View>(recyclerViewId) as RecyclerView
                    if (recyclerView != null && recyclerView.id == recyclerViewId) {
                        val viewHolder =
                            recyclerView.findViewHolderForAdapterPosition(position)
                        if (viewHolder != null) {
                            childView = viewHolder.itemView
                        }
                    } else {
                        return false
                    }
                }
                return if (targetViewId == -1) {
                    view === childView
                } else {
                    val targetView =
                        childView!!.findViewById<View>(targetViewId)
                    view === targetView
                }
            }
        }
    }

    companion object {
        fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
            return RecyclerViewMatcher(
                recyclerViewId
            )
        }

        fun checkIfDisplayedOnRecycleViewItem(
            recyclerViewId: Int,
            position: Int,
            contentId: Int
        ) {
            Espresso.onView(
                withRecyclerView(
                    recyclerViewId
                ).atPosition(position)
            )
                .check(
                    ViewAssertions.matches(
                        ViewMatchers.hasDescendant(
                            ViewMatchers.withId(
                                contentId
                            )
                        )
                    )
                )
        }

        fun checkTextOnRecycleViewItem(
            recyclerViewId: Int,
            position: Int,
            contentId: Int,
            text: String?
        ) {
            Espresso.onView(
                withRecyclerView(
                    recyclerViewId
                )
                    .atPositionOnView(position, contentId)
            )
                .check(ViewAssertions.matches(ViewMatchers.withText(text)))
        }

        fun checkIfIsDisplayedWithTextOnRecyclerView(
            recyclerViewId: Int,
            position: Int,
            text: String?
        ) {
            Espresso.onView(
                withRecyclerView(
                    recyclerViewId
                ).atPosition(position)
            )
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText(text))))
        }
    }

}