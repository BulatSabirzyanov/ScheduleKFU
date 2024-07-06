package com.example.schedulekfu

import com.example.schedule.presentation.ScheduleFragment
import com.example.schedule.presentation.SearchScheduleFragment
import com.example.schedule.presentation.ViewPagerFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
//    fun ScheduleDetail() = FragmentScreen { ScheduleDetailFragment() }

    fun ViewPager(groupId: String) = FragmentScreen { ViewPagerFragment.newInstance(groupId) }
    fun SearchSchedule() = FragmentScreen { SearchScheduleFragment() }
    fun Schedule(position: Int, groupId: String) =
        FragmentScreen { ScheduleFragment.newInstance(position, groupId) }

    fun Main() = FragmentScreen { MainFragment() }
}