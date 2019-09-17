package com.jonzarate.jpmchasealbums

import android.view.View
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

object Matchers {

    fun withListSize(size: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun matchesSafely(view: View): Boolean {
                return (view as RecyclerView).adapter?.itemCount == size
            }

            override fun describeTo(description: Description?) {
                description?.appendText("RecyclerView should have $size items")
            }
        }
    }
}