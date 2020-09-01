package com.example.alarmclock.util

import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test
import java.util.*

class ExtensionTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


    // ------------------------- Tests ------------------------- //

    @Test
    fun `correctTime, return the set time as a String`() {
        assertThat(correctTime(11, 0), equalTo("11:00"))
    }

    @Test
    fun `add0IfNeeded, check if number is less than 10 and add a 0 in front of it and return as a String`() {
        assertThat(1.add0IfNeeded(), equalTo("01"))
    }

    @Test
    fun `add0IfNeeded, check if number is 10 or more without doing anything and return as a String`() {
        assertThat(10.add0IfNeeded(), equalTo("10"))
    }

    @Test
    fun `splitting, split a string at a certain place and return List of Strings`() {
        var list = listOf("12", "00")
        assertThat("12:00".splitting(), equalTo(list))
    }

    @Test
    fun `reqCode, random number generator from 0 - 1000`() {
        var reqCode = reqCode()
        assertThat(reqCode, equalTo(reqCode))
    }

    @Test
    fun `getAlarmCalendar, set hour and time to be returned in milliseconds in calendar`(){
        val calNow = Calendar.getInstance()
        val calSet = calNow.clone() as Calendar

        calSet[Calendar.HOUR_OF_DAY] = 11
        calSet[Calendar.MINUTE] = 15
        calSet[Calendar.SECOND] = 0
        calSet[Calendar.MILLISECOND] = 0

        assertThat(getAlarmCalendar(11, 15), equalTo(calSet.timeInMillis))
    }
}