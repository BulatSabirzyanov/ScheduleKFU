package com.example.schedulekfu

import android.app.Application
import com.example.schedule.di.deps.ScheduleDepsStore
import com.example.schedulekfu.di.AppComponentHolder

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponentHolder.build(applicationContext)
        ScheduleDepsStore.deps = AppComponentHolder.get()
    }
}