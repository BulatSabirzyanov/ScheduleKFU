package com.example.schedulekfu.di

import android.content.Context
import com.example.common.di.holder.DiComponent
import com.example.schedule.di.deps.ScheduleDeps
//import com.example.schedule.detail.di.deps.ScheduleDetailDeps
//import com.example.schedule.detail.ui.di.deps.ScheduleDetailUiDeps
//import com.example.schedule.di.deps.ScheduleDeps
import com.example.schedulekfu.MainActivity
import com.example.schedulekfu.MainFragment
import com.example.schedulekfu.di.bind.AppBindModule
//import com.example.schedulekfu.di.bind.AppBindModule
import com.example.schedulekfu.di.db.AppDatabaseModule
import com.example.schedulekfu.di.navigation.AppNavigationModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : ScheduleDeps,
//    ScheduleDetailDeps,
    DiComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
}

@Module(
    includes = [AppNavigationModule::class, AppDatabaseModule::class, AppBindModule::class
    ]
)
class AppModule
