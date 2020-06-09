package com.example.alarmclock.di

import androidx.room.Room
import com.example.alarmclock.repository.AlarmClockRepository
import com.example.alarmclock.repository.AlarmClockRepositoryImpl
import com.example.alarmclock.room.AlarmRoomDatabase
import com.example.alarmclock.room.ALARM_DATABASE_NAME
import com.example.alarmclock.util.Swipe
import com.example.alarmclock.util.NavigationImpl
import com.example.alarmclock.view.alarmClock.AlarmClockViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //-- Room Database --//
    // Room Database
    single {
        Room.databaseBuilder(get(), AlarmRoomDatabase::class.java, ALARM_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    // Dao
    single { get<AlarmRoomDatabase>().alarmDao() }

    //Repository w/ interface
    single<AlarmClockRepository> { AlarmClockRepositoryImpl(get()) }
    //----//

    factory { NavigationImpl() }
    factory { Swipe() }
}

val viewModelModule = module {
    viewModel { AlarmClockViewModel(get()) }
}