package com.example.schedule.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.schedule.presentation.ScheduleViewModel
import com.example.schedule.presentation.SearchScheduleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ScheduleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    fun scheduleViewModel(viewModel: ScheduleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchScheduleViewModel::class)
    fun searchScheduleViewModel(viewModel: SearchScheduleViewModel): ViewModel
}