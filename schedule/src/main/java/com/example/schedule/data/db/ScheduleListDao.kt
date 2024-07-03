package com.example.schedule.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.schedule.data.db.entity.SubjectList

@Dao
interface ScheduleListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scheduleList: SubjectList)

//    @Transaction
//    @Query("SELECT * FROM SubjectList")
//    fun getAllScheduleLists(): Flow<List<SubjectList>>

}