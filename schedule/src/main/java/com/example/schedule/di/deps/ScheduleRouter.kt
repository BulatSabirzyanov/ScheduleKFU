package com.example.schedule.di.deps

interface ScheduleRouter {

    fun navigateToSearchSchedule()

    fun navigateToSchedule(groupId: String, year: String, semester: String)

    fun exit()
}