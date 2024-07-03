package com.example.schedulekfu.di.bind

import com.example.schedule.di.deps.ScheduleDatabase
import com.example.schedule.di.deps.ScheduleRouter
import com.example.schedulekfu.AppDatabase
import com.example.schedulekfu.di.navigation.wrappers.ScheduleRouterWrapper
import dagger.Binds
import dagger.Module

@Module
interface ScheduleDepsBindModule {

    @Binds
    fun bindScheduleRouterHolderToScheduleRouter(
        scheduleRouterWrapper: ScheduleRouterWrapper
    ): ScheduleRouter

    @Binds
    fun bindAppDatabaseToScheduleDatabase(
        appDatabase: AppDatabase
    ): ScheduleDatabase
}