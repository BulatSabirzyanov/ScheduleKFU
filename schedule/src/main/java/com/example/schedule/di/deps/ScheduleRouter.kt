package com.example.schedule.di.deps

interface ScheduleRouter {

    fun navigateToSearchSchedule()

    fun navigateToViewPager(groupId: String)

    fun navigateToSchedule(position: Int, groupId: String)

    fun exit()
}