package com.example.schedule.di.deps

import androidx.annotation.RestrictTo
import kotlin.properties.Delegates

object ScheduleDepsStore : ScheduleDepsProvider {

    override var deps: ScheduleDeps by Delegates.notNull()
}

interface ScheduleDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: ScheduleDeps

    companion object : ScheduleDepsProvider by ScheduleDepsStore
}
