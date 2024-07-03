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

    override fun navigateToSchedule(groupId: String, year: String, semester: String) {
        router.navigateTo(Screens.Schedule(groupId, year, semester))
    }

    override fun exit() {
        router.exit()
    }
}
