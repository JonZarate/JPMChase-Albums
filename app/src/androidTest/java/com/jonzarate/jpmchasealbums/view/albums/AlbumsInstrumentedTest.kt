package com.jonzarate.jpmchasealbums.view.albums

import android.content.pm.ActivityInfo
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.jonzarate.jpmchasealbums.Matchers
import com.jonzarate.jpmchasealbums.R
import com.jonzarate.jpmchasealbums.view.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumsInstrumentedTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_PageIsScrollable() {
        val recyclerView = activity.activity.findViewById(R.id.album_list) as RecyclerView
        val lastItem = (recyclerView.layoutManager as LinearLayoutManager)
            .findLastCompletelyVisibleItemPosition()

        onView(withId(R.id.album_list))
            .check(matches(isDisplayed()))
            .perform(ViewActions.swipeUp())

        val newLastItem = (recyclerView.layoutManager as LinearLayoutManager)
            .findLastCompletelyVisibleItemPosition()

        assertNotEquals(lastItem, newLastItem)
    }

    @Test
    fun test_TypingFiltersResults () {
        onView(withId(R.id.album_list))
            .check(matches(isDisplayed()))
            .check(matches(Matchers.withListSize(100)))

        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(typeText("expedita"))

        onView(withId(R.id.album_list))
            .check(matches(isDisplayed()))
            .check(matches(Matchers.withListSize(3)))
    }
}
