package com.example.alarmclock.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.alarmclock.R
import com.example.alarmclock.view.alarmClock.AlarmClockAdapter.*
import org.junit.After
import org.junit.Before

import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun click_fab_to_start_TimePickerFragmentDialog() {
        start_timePickerFragmentDialog()
    }

    @Test
    fun click_ok_on_TimePickerFragmentDialog() {
        start_timePickerFragmentDialog()

        onView(withText("OK"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Test
    fun check_if_item_was_added_to_recyclerview() {

        start_timePickerFragmentDialog()

        onView(withText("OK"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.alarmRecyclerView)).perform(
            actionOnItemAtPosition<AlarmClockViewHolder>(0, click())
        ).check(matches(isDisplayed()))
    }


    private fun start_timePickerFragmentDialog() {
        onView(withId(R.id.fabShowDialog)).perform(click())
        onView(withText("OK")).check(matches(isDisplayed()))
    }
}