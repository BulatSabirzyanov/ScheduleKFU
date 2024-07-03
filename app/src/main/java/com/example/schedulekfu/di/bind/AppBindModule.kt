package com.example.schedulekfu.di.bind

import dagger.Module

@Module(
    includes = [
        ScheduleDepsBindModule::class,
//        ScheduleDetailDepsBindModule::class,
    ]
)
class AppBindModule