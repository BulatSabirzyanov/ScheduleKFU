package com.example.schedule.di.deps

import com.example.common.di.deps.CommonDeps

interface ScheduleDeps : CommonDeps {
    val scheduleDatabase: ScheduleDatabase
    val scheduleRouter: ScheduleRouter
}