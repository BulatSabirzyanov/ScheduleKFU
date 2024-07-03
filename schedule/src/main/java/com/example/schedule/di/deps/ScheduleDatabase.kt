package com.example.schedule.di.deps

import com.example.schedule.data.db.ScheduleListDao

interface ScheduleDatabase {
    fun scheduleListDao(): ScheduleListDao
}
