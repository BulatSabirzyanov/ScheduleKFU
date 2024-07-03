package com.example.schedule.di

import com.example.common.di.holder.FeatureComponentHolder
import com.example.schedule.di.deps.ScheduleDepsStore

class ScheduleComponentHolder : FeatureComponentHolder<ScheduleComponent>() {
    override fun build(): ScheduleComponent =
        DaggerScheduleComponent.builder()
            .dependencies(ScheduleDepsStore.deps)
            .build()
}