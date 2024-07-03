package com.example.schedule.di.bind

import dagger.Module

@Module(
    includes = [ScheduleDataLayerBindModule::class, ScheduleDomainLayerBindModule::class]
)
class ScheduleBindModule {
}