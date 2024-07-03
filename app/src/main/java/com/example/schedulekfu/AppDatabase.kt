package com.example.schedulekfu

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.schedule.data.db.ScheduleListDao
import com.example.schedule.data.db.entity.SubjectList
import com.example.schedule.di.deps.ScheduleDatabase

@Database(
    entities = [
        SubjectList::class,
//        ScheduleItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() , ScheduleDatabase {

    abstract override fun scheduleListDao(): ScheduleListDao

//    abstract override fun scheduleDetailListItemDao(): ScheduleDetailItemDao

    companion object {
        const val DB_NAME = "AppDataBase"
    }
}