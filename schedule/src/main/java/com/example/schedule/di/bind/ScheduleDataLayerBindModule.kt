package com.example.schedule.di.bind

import com.example.schedule.data.ScheduleRepositoryImpl
import com.example.schedule.domain.ScheduleRepository
import dagger.Binds
import dagger.Module

@Module
internal interface ScheduleDataLayerBindModule {

    @Binds
    fun bindScheduleRepositoryImplToScheduleRepository(
        scheduleRepositoryImpl: ScheduleRepositoryImpl
    ) : ScheduleRepository
}