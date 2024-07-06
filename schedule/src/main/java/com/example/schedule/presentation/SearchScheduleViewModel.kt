package com.example.schedule.presentation

import androidx.lifecycle.ViewModel
import com.example.schedule.di.deps.ScheduleRouter
import javax.inject.Inject

class SearchScheduleViewModel @Inject constructor(
    private val router: ScheduleRouter
) : ViewModel() {

    fun navigateToViewPager(groupId: String){
        router.navigateToViewPager(groupId)
    }


}