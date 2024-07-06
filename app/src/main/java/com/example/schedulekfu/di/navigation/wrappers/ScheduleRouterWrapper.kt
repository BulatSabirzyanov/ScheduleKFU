package com.example.schedulekfu.di.navigation.wrappers

import com.example.schedule.di.deps.ScheduleRouter
import com.example.schedulekfu.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ScheduleRouterWrapper @Inject constructor(
    private val router: Router
) : ScheduleRouter {

    override fun navigateToSearchSchedule() {
        router.navigateTo(Screens.SearchSchedule())
    }

    override fun navigateToViewPager(groupId: String) {
        router.navigateTo(Screens.ViewPager(groupId))
    }

    override fun navigateToSchedule(position: Int, groupId: String) {
        router.navigateTo(Screens.Schedule(position, groupId))
    }

    override fun exit() {
        router.exit()
    }
}
