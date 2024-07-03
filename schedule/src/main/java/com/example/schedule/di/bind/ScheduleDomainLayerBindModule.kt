package com.example.schedule.di.bind

import com.example.schedule.data.usecases.GetScheduleUseCaseImpl
import com.example.schedule.domain.usecases.GetScheduleUseCase
import dagger.Binds
import dagger.Module

@Module
internal interface ScheduleDomainLayerBindModule {

    @Binds
    fun bindGetAllScheduleListsUseCaseImplToGetAllScheduleListsUseCase(
        getScheduleUseCaseImpl: GetScheduleUseCaseImpl
    ): GetScheduleUseCase
}