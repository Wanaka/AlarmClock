package com.example.alarmclock

import androidx.fragment.app.FragmentManager
import com.example.alarmclock.di.appModule
import com.example.alarmclock.util.NavigationImpl
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.koin.core.inject
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ExampleUnitTest: KoinTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
