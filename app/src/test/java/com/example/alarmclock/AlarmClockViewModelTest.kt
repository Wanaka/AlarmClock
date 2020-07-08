package com.example.alarmclock

import android.icu.text.DateTimePatternGenerator.PatternInfo.OK
import android.os.AsyncTask
import android.os.AsyncTask.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.alarmclock.repository.AlarmClockRepositoryImpl
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.correctTime
import com.example.alarmclock.view.alarmClock.AlarmClockViewModel
import com.example.alarmclock.view.alarmClock.Status
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
class AlarmClockViewModelTest {

    @get: Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(dispatcher)

    var repo = mockk<AlarmClockRepositoryImpl>()
    lateinit var vmSUT: AlarmClockViewModel
    private lateinit var listLiveData: MutableLiveData<List<AlarmItem>>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(dispatcher)

        vmSUT = AlarmClockViewModel(repo)
        listLiveData = MutableLiveData<List<AlarmItem>>()
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    // -------------------------------- Tests -------------------------------- //
    @Test
    fun calc() {
        assertThat(3, `is`(vmSUT.add(1, 2)))
    }

    @Test
    fun `Run getList() and get LiveData from Repository`() {
        getMockData()

        every { vmSUT.getList() } returns listLiveData // when function runs we expect this result every time

        vmSUT.getList() // run the test

        verify { vmSUT.getList() } // verify that the call happened

        confirmVerified(repo) // confirm that all calls has been verified (mocks)
    }

    /*
    *  I want to check if sending data from vm to repo works.
    */
    @Test
    fun test() {
        dispatcher.runBlockingTest {

//            every { vmSUT.getStatus() } returns Status.SUCCESS // when function runs we expect this result every time
//
//            vmSUT.setStatus(Status.LOADING)
//            vmSUT.setAlarmTime(11, 0, 1) // run the test
//            vmSUT.setStatus(Status.SUCCESS)
//            vmSUT.getStatus()
//
////            verify { vmSUT.setAlarmTime(11, 0, 1) } // verify that the call happened
//            verify { vmSUT.getStatus() }
//            verify { vmSUT.setStatus(Status.SUCCESS) }
//
//            confirmVerified(repo) // confirm that all calls has been verified (mocks)

        }

    }

    private fun getMockData() {
        var list = listOf(
            AlarmItem(1, "07:00", true, 1),
            AlarmItem(2, "10:00", false, 2)
        )

        listLiveData.postValue(list)
    }

}