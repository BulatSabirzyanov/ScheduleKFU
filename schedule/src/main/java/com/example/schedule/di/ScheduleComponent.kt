package com.example.schedule.di

import com.example.common.di.holder.DiComponent
import com.example.schedule.di.bind.ScheduleBindModule
import com.example.schedule.di.data.ScheduleListDaoModule
import com.example.schedule.di.deps.ScheduleDeps
import com.example.schedule.di.network.NetworkModule
import com.example.schedule.di.viewmodel.ScheduleViewModelModule
import com.example.schedule.presentation.ScheduleFragment
import com.example.schedule.presentation.SearchScheduleFragment
import dagger.Component
import dagger.Module

@Component(
    dependencies = [ScheduleDeps::class],
    modules = [ScheduleModule::class]
)
interface ScheduleComponent : DiComponent{


    fun inject(scheduleFragment: ScheduleFragment)

    fun inject(searchScheduleFragment: SearchScheduleFragment)

    @Component.Builder
    interface Builder {
        fun dependencies(scheduleDeps: ScheduleDeps): Builder
        fun build(): ScheduleComponent
    }

}

@Module(
    includes = [ScheduleListDaoModule::class, ScheduleBindModule::class , ScheduleViewModelModule::class, NetworkModule::class]
)
class ScheduleModule

