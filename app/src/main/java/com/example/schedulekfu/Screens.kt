package com.example.schedulekfu

import com.example.schedule.presentation.ScheduleFragment
import com.example.schedule.presentation.SearchScheduleFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
//    fun ScheduleDetail() = FragmentScreen { ScheduleDetailFragment() }

    fun SearchSchedule() = FragmentScreen { SearchScheduleFragment() }
    fun Schedule(groupId: String, year: String, semester: String) = FragmentScreen { ScheduleFragment.newInstance(groupId, year, semester) }
    fun Main() = FragmentScreen { MainFragment() }
}